package com.github.user.client.core;

import com.github.user.client.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private NotLoggedInExceptionHandler notLoggedInExceptionHandler;

    @Autowired
    private UnauthorizedExceptionHandler unauthorizedExceptionHandler;

    @Autowired
    private UserApiExceptionHandler userApiExceptionHandler;

    @Autowired
    private DefaultExceptionHandler defaultExceptionHandler;

    /**
     * 异常处理器集合
     */
    private List<HandlerBase> exceptionHandlers;

    private void initialize() {
        if (exceptionHandlers == null) {
            exceptionHandlers = Arrays.asList(
                    notLoggedInExceptionHandler,
                    unauthorizedExceptionHandler,
                    userApiExceptionHandler,
                    defaultExceptionHandler
            );
        }
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        initialize();
        for (HandlerBase exceptionHandler : exceptionHandlers) {
            if (exceptionHandler.canHandle(ex)) {
                return exceptionHandler.handle(request, response, handler, ex);
            }
        }
        return new ModelAndView();
    }
}
