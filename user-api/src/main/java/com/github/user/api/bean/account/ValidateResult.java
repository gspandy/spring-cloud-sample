package com.github.user.api.bean.account;

import com.github.user.api.bean.UserApiResult;

/**
 * 验证结果
 */
public class ValidateResult extends UserApiResult {

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
