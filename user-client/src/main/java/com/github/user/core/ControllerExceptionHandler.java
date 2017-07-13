package com.github.user.core;

import com.github.user.exception.DefaultExceptionHandler;
import com.github.user.exception.HandlerBase;
import com.github.user.exception.NotLoggedInExceptionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * 控制器异常处理
 */
@Component
class ControllerExceptionHandler implements HandlerExceptionResolver {

    /**
     * 异常处理器集合
     */
    private List<HandlerBase> exceptionHandlers;

    public ControllerExceptionHandler() {
        exceptionHandlers = Arrays.asList(
                new NotLoggedInExceptionHandler(),
                new DefaultExceptionHandler());
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        for (HandlerBase exceptionHandler : exceptionHandlers) {
            if (exceptionHandler.canHandle(ex)) {
                return exceptionHandler.handle(request, response, handler, ex);
            }
        }
        return new ModelAndView();
    }
}
