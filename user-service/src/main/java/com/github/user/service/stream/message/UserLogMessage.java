package com.github.user.service.stream.message;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户操作日志消息
 */
public class UserLogMessage {

    /**
     * 日志id
     */
    @NotNull
    @Size(min = 36, max = 36)
    private String logId;

    /**
     * 日志类型
     */
    @NotNull
    private Integer logType;

    /**
     * 操作用户id
     */
    @NotNull
    private Integer userId;

    /**
     * 日志信息
     */
    @NotNull
    private String logMessage;

    /**
     * 日志日期
     */
    @NotNull
    private java.util.Date logDate;

    /**
     * 获取日志id
     * @return 日志id
     */
    public String getLogId() {
        return logId;
    }

    /**
     * 设置日志id
     * @param logId 日志id
     */
    public void setLogId(String logId) {
        this.logId = logId;
    }

    /**
     * 获取日志类型
     * @return 日志类型
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     * 设置日志类型
     * @param logType 日志类型
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * 获取操作用户id
     * @return 操作用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置操作用户id
     * @param userId 操作用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取日志信息
     * @return 日志信息
     */
    public String getLogMessage() {
        return logMessage;
    }

    /**
     * 设置日志信息
     * @param logMessage 日志信息
     */
    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    /**
     * 获取日志日期
     * @return 日志日期
     */
    public java.util.Date getLogDate() {
        return logDate;
    }

    /**
     * 设置日志日期
     * @param logDate 日志日期
     */
    public void setLogDate(java.util.Date logDate) {
        this.logDate = logDate;
    }
}
