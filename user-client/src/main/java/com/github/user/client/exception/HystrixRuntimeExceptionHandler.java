package com.github.user.client.exception;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Hystrix运行时异常处理器
 */
@Component
public class HystrixRuntimeExceptionHandler extends HandlerBase {

    private List<HandlerBase> exceptionHandlers;

    @Autowired
    private UserApiExceptionHandler userApiExceptionHandler;

    @Autowired
    private DefaultExceptionHandler defaultExceptionHandler;

    public void initialize() {
        exceptionHandlers = Arrays.asList(userApiExceptionHandler, defaultExceptionHandler);
    }

    @Override
    public boolean canHandle(Exception ex) {
        return ex instanceof HystrixRuntimeException;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        initialize();
        HystrixRuntimeException hystrixRuntimeException = (HystrixRuntimeException) ex;
        for (HandlerBase exceptionHandler : exceptionHandlers) {
            if (exceptionHandler.canHandle((Exception) hystrixRuntimeException.getCause())) {
                return exceptionHandler.handle(request, response, handler, (Exception) hystrixRuntimeException.getCause());
            }
        }
        return new ModelAndView();
    }
}
