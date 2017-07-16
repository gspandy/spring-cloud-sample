package com.github.user.client.exception;

import com.alibaba.fastjson.JSON;
import com.github.user.client.model.ErrorInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未授权异常处理器
 */
@Component
public class UnauthorizedExceptionHandler extends HandlerBase {

    @Override
    public boolean canHandle(Exception ex) {
        return ex instanceof UnauthorizedException;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage("未被授权进行此操作");
        if (isJsonResponse(request, handler)) {
            response.setContentType("application/json;charset=UTF-8");
            try {
                response.getWriter().write(JSON.toJSONString(errorInfo));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return new ModelAndView();
        } else {
            ModelAndView view = new ModelAndView("/home/error");
            view.addObject("errorInfo", errorInfo);
            return view;
        }
    }
}
