package com.github.user.api.model;

/**
 * 异常信息
 */
public class UserExceptionInfo {

    /**
     * 异常类
     */
    private String exceptionClass;

    /**
     * 异常数据
     */
    private UserExceptionData userExceptionData;

    /**
     * 获取异常类
     * @return 异常类
     */
    public String getExceptionClass() {
        return exceptionClass;
    }

    /**
     * 设置异常类
     * @param exceptionClass 异常类
     */
    public void setExceptionClass(String exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    /**
     * 获取异常数据
     * @return 异常数据
     */
    public UserExceptionData getUserExceptionData() {
        return userExceptionData;
    }

    /**
     * 设置异常数据
     * @param userExceptionData 异常数据
     */
    public void setUserExceptionData(UserExceptionData userExceptionData) {
        this.userExceptionData = userExceptionData;
    }
}
