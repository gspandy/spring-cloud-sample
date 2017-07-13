package com.github.user.exception;

import com.alibaba.fastjson.JSON;
import com.github.user.model.ErrorInfo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 默认的异常处理器
 */
public class DefaultExceptionHandler extends HandlerBase {

    @Override
    public boolean canHandle(Exception ex) {
        return true;
    }

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setMessage("系统出错啦，请重新尝试，如果多次出现此错误，请联系客服人员");
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
