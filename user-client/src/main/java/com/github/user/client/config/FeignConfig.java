package com.github.user.client.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.user.api.exception.UserApiException;
import com.github.user.api.model.UserExceptionInfo;
import feign.Feign;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrations;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.IOException;
import java.util.Collection;

/**
 * Feign配置
 */
@Configuration
@ConditionalOnClass({Feign.class})
class FeignConfig {

    private ErrorDecoder defaultErrorDecoder = new ErrorDecoder.Default();

    @Bean
    public WebMvcRegistrations feignWebRegistrations() {
        return new WebMvcRegistrationsAdapter() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new RequestMappingHandlerMapping() {
                    @Override
                    protected boolean isHandler(Class<?> beanType) {
                        return super.isHandler(beanType) && (AnnotationUtils.findAnnotation(beanType, FeignClient.class) == null);
                    }
                };
            }
        };
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return (String s, Response response) -> {
            if (response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                Collection<String> contentTypes = response.headers().get("Content-Type");
                if (contentTypes != null
                        && contentTypes.stream().anyMatch(contentType -> contentType.contains("application/json"))) {
                    try {
                        JSONObject responseJson = JSON.parseObject(IOUtils.toString(response.body().asInputStream(), "UTF-8"));
                        String exceptionClass = responseJson.getString("exceptionClass");
                        if (exceptionClass != null && exceptionClass.length() > 0) {
                            if (UserApiException.class.getName().equals(exceptionClass)) {
                                UserExceptionInfo userExceptionInfo = JSON.parseObject(responseJson.toJSONString(), UserExceptionInfo.class);
                                return new UserApiException(userExceptionInfo.getUserExceptionData().getCode(), userExceptionInfo.getUserExceptionData().getMessage());
                            }
                        }
                    } catch (IOException e) {
                        return e;
                    }
                }
            }
            return defaultErrorDecoder.decode(s, response);
        };
    }
}
