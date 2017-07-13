package com.github.user.entity;

/**
 * 权限
 */
public class Permission {

    /**
     * 权限id
     */
    private Integer permissionId;

    /**
     * 权限码
     */
    private Long permissionCode;

    /**
     * 组id
     */
    private Integer groupId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 获取权限id
     * @return 权限id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限id
     * @param permissionId 权限id
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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
     * 获取组id
     * @return 组id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置组id
     * @param groupId 组id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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

}