package com.github.user.api.model;

/**
 * 异常数据
 */
public class UserExceptionData {

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 获取异常码
     * @return 异常码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置异常码
     * @param code 异常码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取异常信息
     * @return 异常信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置异常信息
     * @param message 异常信息
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
