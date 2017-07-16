package com.github.user.service.entity;

import java.util.Date;

/**
 * 用户登录
 */
public class UserLogin {

    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 客户端版本
     */
    private String clientVersion;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 权限码
     */
    private Long permissionCode;

    /**
     * 登录日期
     */
    private Date loginDate;

    /**
     * 获取访问令牌
     * @return 访问令牌
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 设置访问令牌
     * @param accessToken 访问令牌
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * 获取客户端id
     * @return 客户端id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置客户端id
     * @param clientId 客户端id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取客户端版本
     * @return 客户端版本
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * 设置客户端版本
     * @param clientVersion 客户端版本
     */
    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

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
     * 获取权限码
     * @return 权限码
     */
    public Long getPermissionCode() {
        return permissionCode;
    }

    /**
     * 设置权限码
     * @param permissionCode 权限码
     */
    public void setPermissionCode(Long permissionCode) {
        this.permissionCode = permissionCode;
    }

    /**
     * 获取登录日期
     * @return 登录日期
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * 设置登录日期
     * @param loginDate 登录日期
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
