package com.github.user.api.core;

/**
 * 权限码定义
 */
public class PermissionCodes {

    /**
     * 查看用户
     */
    public static final long VIEW_USER = 1;

    /**
     * 新增用户
     */
    public static final long CREATE_USER = 2;

    /**
     * 修改用户
     */
    public static final long UPDATE_USER = 4;

    /**
     * 删除用户
     */
    public static final long DELETE_USER = 8;

    /**
     * 查看组
     */
    public static final long VIEW_GROUP = 16;

    /**
     * 新增组
     */
    public static final long CREATE_GROUP = 32;

    /**
     * 更新组
     */
    public static final long UPDATE_GROUP = 64;

    /**
     * 删除组
     */
    public static final long DELETE_GROUP = 128;
}
