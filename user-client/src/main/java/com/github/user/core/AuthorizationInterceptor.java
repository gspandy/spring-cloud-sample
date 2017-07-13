package com.github.user.core;

import com.github.user.ControllerBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户授权拦截器
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserContextProcessor userContextProcessor;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Object handlerBean = handlerMethod.getBean();
            if (handlerBean instanceof ControllerBase) {
                List<Authorize> authorizes = new ArrayList<>();
                Authorize authorize = handlerMethod.getMethodAnnotation(Authorize.class);
                if (authorize != null) {
                    authorizes.add(authorize);
                }
                authorize = handlerMethod.getBeanType().getAnnotation(Authorize.class);
                if (authorize != null) {
                    authorizes.add(authorize);
                }
                if (authorizes.size() > 0) {
                    userContextProcessor.process(
                            authorizes.stream().map(Authorize::permission).reduce((p1, p2) -> p1 + p2).get(),
                            request);
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
