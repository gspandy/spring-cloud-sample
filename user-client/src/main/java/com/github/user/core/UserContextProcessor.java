package com.github.user.core;

import com.github.user.ControllerBase;
import com.github.user.exception.NotLoggedInException;
import com.github.user.model.UserContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * 访问令牌处理器
 */
@Component
public class UserContextProcessor {

    /**
     * 访问令牌主键
     */
    private static final String ACCESS_TOKEN_KEY = "access_token";

    /**
     * 处理用户上下文
     * @param permission 权限码
     * @param request HttpServletRequest对象
     */
    public void process(long permission, HttpServletRequest request) throws NotLoggedInException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) throw new NotLoggedInException();
        String accessToken = Stream.of(cookies)
                .filter(cookie -> ACCESS_TOKEN_KEY.equals(cookie.getName()))
                .findFirst()
                .orElseThrow(NotLoggedInException::new)
                .getValue();
        if (accessToken == null || accessToken.length() == 0) throw new NotLoggedInException();
        UserContext userContext = new UserContext();
        userContext.setAccessToken(accessToken);
        request.setAttribute(ControllerBase.USER_CONTEXT_KEY, userContext);
    }

    /**
     * 初始化用户上下文
     * @param userContext 用户上下文
     * @param request HttpServletRequest对象
     * @param response HttpServletResponse对象
     */
    public void initialize(UserContext userContext, HttpServletRequest request, HttpServletResponse response) {
        if (userContext.getAccessToken() == null || userContext.getAccessToken().length() == 0) {
            userContext.setAccessToken(UUID.randomUUID().toString());
            request.setAttribute(ControllerBase.USER_CONTEXT_KEY, userContext);
            Cookie cookie = new Cookie(ACCESS_TOKEN_KEY, userContext.getAccessToken());
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    /**
     * 删除用户上下文
     * @param userContext 用户上下文
     * @param response HttpServletResponse对象
     */
    public void destroy(UserContext userContext, HttpServletResponse response) {
        Cookie cookie = new Cookie(ACCESS_TOKEN_KEY, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
