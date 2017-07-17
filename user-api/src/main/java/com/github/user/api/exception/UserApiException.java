package com.github.user.api.exception;

import com.netflix.hystrix.exception.ExceptionNotWrappedByHystrix;
import com.netflix.hystrix.exception.HystrixBadRequestException;

/**
 * 用户Api异常
 */
public class UserApiException extends HystrixBadRequestException implements ExceptionNotWrappedByHystrix {

    /**
     * 无效的用户名
     */
    public static final String INVALID_USERNAME = "invalid_username";

    /**
     * 错误的密码
     */
    public static final String WRONG_PASSWORD = "wrong_password";

    /**
     * 无效的用户id
     */
    public static final String INVALID_USER_ID = "invalid_user_id";

    /**
     * 无效的访问令牌
     */
    public static final String INVALID_ACCESS_TOKEN = "invalid_access_token";

    /**
     * 创建用户Api异常
     * @param code 异常码
     * @param message 异常信息
     */
    public UserApiException(String code, String message) {
        super(message);
        this.code = code;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    /**
     * 异常码
     */
    private String code;

    /**
     * 获取异常码
     * @return 异常码
     */
    public String getCode() {
        return code;
    }
}
