package com.github.user.client.exception;

import com.alibaba.fastjson.JSON;
import com.github.user.api.exception.UserApiException;
import com.github.user.client.model.ErrorInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户api异常处理器
 */
@Component
public class UserApiExceptionHandler extends HandlerBase {

    @Override
    public boolean canHandle(Exception ex) {
        return ex instanceof UserApiException;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        UserApiException userApiException = (UserApiException) ex;
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage(ex.getMessage());
        if (isJsonResponse(request, handler)) {
            response.setContentType("application/json;charset=UTF-8");
            try {
                response.getWriter().write(JSON.toJSONString(errorInfo));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return new ModelAndView();
        } else {
            ModelAndView view = new ModelAndView();
            if (UserApiException.INVALID_USERNAME.equals(userApiException.getCode())
                    || UserApiException.WRONG_PASSWORD.equals(userApiException.getCode())) {
                view.setViewName("/account/login");
                view.addObject("errorMessage", "登录凭据错误");
            } else if (UserApiException.INVALID_ACCESS_TOKEN.equals(userApiException.getCode())) {
                view.setViewName("redirect:/account/login");
            } else {
                view.setViewName("/home/error");
                view.addObject("errorInfo", errorInfo);
            }
            return view;
        }
    }
}
