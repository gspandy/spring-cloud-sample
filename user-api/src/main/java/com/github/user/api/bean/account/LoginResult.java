package com.github.user.api.bean.account;

import com.github.user.api.bean.UserApiResult;

/**
 * 登录结果
 */
public class LoginResult extends UserApiResult {

    /**
     * 访问令牌
     */
    private String accessToken;

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
}
