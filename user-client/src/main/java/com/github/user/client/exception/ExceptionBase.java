package com.github.user.client.exception;

/**
 * 异常基类
 */
public class ExceptionBase extends Exception {

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
