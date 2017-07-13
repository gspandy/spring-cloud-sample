package com.github.user.entity;

/**
 * 用户
 */
public class User {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * Email
     */
    private String email;

    /**
     * 工号
     */
    private String employeeNo;

    /**
     * 出生日期
     */
    private java.util.Date birthday;

    /**
     * 获取用户id
     * @return 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取姓名
     * @return 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取Email
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置Email
     * @param email Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取工号
     * @return 工号
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * 设置工号
     * @param employeeNo 工号
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * 获取出生日期
     * @return 出生日期
     */
    public java.util.Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     * @param birthday 出生日期
     */
    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

}