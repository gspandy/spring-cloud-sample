package com.github.user.entity;

/**
 * 用户
 */
public class User {

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建日期
     */
    private java.util.Date createDate;

    /**
     * 获取用户id
     * @return 用户id
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置用户id
     * @param uid 用户id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
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
     * 获取创建日期
     * @return 创建日期
     */
    public java.util.Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期
     * @param createDate 创建日期
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

}