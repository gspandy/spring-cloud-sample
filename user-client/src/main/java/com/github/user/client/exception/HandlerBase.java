package com.github.user.client.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理器基类
 */
public abstract class HandlerBase {

    /**
     * 判断是否需要输出json
     * @param request HttpServletRequest对象
     * @param handler HandlerMethod对象
     * @return 需要输出json返回true，否则返回false
     */
    protected boolean isJsonResponse(HttpServletRequest request, Object handler) {
        if (handler instanceof HandlerMethod) {
            RequestMapping requestMapping = ((HandlerMethod) handler).getMethodAnnotation(RequestMapping.class);
            return requestMapping.produces().length > 0 && requestMapping.produces()[0].contains("json");
        }
        return false;
    }

    /**
     * 是否可以处理指定的异常
     * @param ex 异常
     * @return 可处理返回true，否则为false
     */
    public abstract boolean canHandle(Exception ex);

    /**
     * 处理异常
     * @param request HttpServletRequest对象
     * @param response HttpServletResponse对象
     * @param handler HandlerMethod对象
     * @param ex 异常
     * @return ModelAndView对象
     */
    public abstract ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex);
}
