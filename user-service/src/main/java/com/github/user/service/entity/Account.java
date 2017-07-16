package com.github.user.service.entity;

/**
 * 用户账号
 */
public class Account {

    /**
     * 账号id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 最近登录日期
     */
    private java.util.Date lastLoginDate;

    /**
     * 获取账号id
     * @return 账号id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置账号id
     * @param userId 账号id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取最近登录日期
     * @return 最近登录日期
     */
    public java.util.Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 设置最近登录日期
     * @param lastLoginDate 最近登录日期
     */
    public void setLastLoginDate(java.util.Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

}