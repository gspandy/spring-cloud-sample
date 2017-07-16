package com.github.user.client.core;

import com.github.user.api.AccountApi;
import com.github.user.client.ControllerBase;
import com.github.user.api.bean.account.ValidateReq;
import com.github.user.client.exception.NotLoggedInException;
import com.github.user.client.exception.UnauthorizedException;
import com.github.user.api.exception.UserApiException;
import com.github.user.client.model.UserContext;
import com.github.user.api.bean.account.ValidateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;

/**
 * 用户上下文处理器
 */
@Component
public class UserContextProcessor {

    /**
     * 访问令牌主键
     */
    private static final String ACCESS_TOKEN_KEY = "access_token";

    @Autowired
    private AccountApi accountApi;

    /**
     * 处理用户上下文
     * @param permission 权限码
     * @param request HttpServletRequest对象
     * @param response HttpServletResponse对象
     */
    public void process(long permission, HttpServletRequest request, HttpServletResponse response) throws NotLoggedInException, UnauthorizedException, UserApiException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) throw new NotLoggedInException();
        String accessToken = Stream.of(cookies)
                .filter(cookie -> ACCESS_TOKEN_KEY.equals(cookie.getName()))
                .findFirst()
                .orElseThrow(NotLoggedInException::new)
                .getValue();
        if (accessToken == null || accessToken.length() == 0) throw new NotLoggedInException();

        ValidateReq validateReq = new ValidateReq();
        validateReq.setAccessToken(accessToken);

        ValidateResult validateResult;
        try {
            validateResult = accountApi.validate(validateReq);
        } catch (UserApiException e) {
            if (UserApiException.INVALID_ACCESS_TOKEN.equals(e.getCode())) {
                UserContext userContext = new UserContext();
                userContext.setAccessToken(validateReq.getAccessToken());
                destroy(userContext, response);
            }
            throw e;
        }

        if ((validateResult.getPermissionCode() & permission) == validateResult.getPermissionCode()) {
            throw new UnauthorizedException();
        }

        UserContext userContext = new UserContext();
        userContext.setAccessToken(accessToken);
        userContext.setName(validateResult.getName());
        userContext.setPermissionCode(validateResult.getPermissionCode());
        userContext.setUserId(validateResult.getUserId());
        request.setAttribute(ControllerBase.USER_CONTEXT_KEY, userContext);
    }

    /**
     * 初始化用户上下文
     * @param userContext 用户上下文
     * @param request HttpServletRequest对象
     * @param response HttpServletResponse对象
     */
    public void initialize(UserContext userContext, HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(ControllerBase.USER_CONTEXT_KEY, userContext);
        Cookie cookie = new Cookie(ACCESS_TOKEN_KEY, userContext.getAccessToken());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 删除用户上下文
     * @param userContext 用户上下文
     * @param response HttpServletResponse对象
     */
    public void destroy(UserContext userContext, HttpServletResponse response) {
        Cookie cookie = new Cookie(ACCESS_TOKEN_KEY, userContext.getAccessToken());
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
