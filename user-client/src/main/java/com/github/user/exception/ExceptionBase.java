package com.github.user.exception;

/**
 * 异常基类
 */
public class ExceptionBase extends Exception {

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
