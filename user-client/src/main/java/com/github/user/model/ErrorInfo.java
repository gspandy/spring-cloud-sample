package com.github.user.model;

/**
 * 错误信息
 */
public class ErrorInfo {

    public ErrorInfo() {
        this.code = "E000";
    }

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 重定向url
     */
    private String redirectUrl;

    /**
     * 获取错误码
     * @return 错误码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置错误码
     * @param code 错误码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取消息
     * @return 消息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置
     * @param message 消息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取重定向url
     * @return 重定向url
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * 设置
     * @param redirectUrl 重定向url
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
