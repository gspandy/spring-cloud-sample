package com.github.user.service.core;

import com.alibaba.fastjson.JSON;
import com.github.user.api.model.UserExceptionData;
import com.github.user.api.exception.UserApiException;
import com.github.user.api.model.UserExceptionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制器异常处理
 */
@Component
class ControllerExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof UserApiException) {
            UserApiException apiException = (UserApiException) ex;
            UserExceptionData userExceptionData = new UserExceptionData();
            userExceptionData.setCode(apiException.getCode());
            userExceptionData.setMessage(apiException.getMessage());
            UserExceptionInfo userExceptionInfo = new UserExceptionInfo();
            userExceptionInfo.setExceptionClass(ex.getClass().getName());
            userExceptionInfo.setUserExceptionData(userExceptionData);

            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            try {
                response.getWriter().write(JSON.toJSONString(userExceptionInfo));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return new ModelAndView();
        }
        throw new RuntimeException(ex);
    }
}
