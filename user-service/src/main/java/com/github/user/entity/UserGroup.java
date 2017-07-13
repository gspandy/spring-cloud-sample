package com.github.user.entity;

/**
 * 用户分组
 */
public class UserGroup {

    /**
     * 用户分组id
     */
    private Integer userGroupId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 分组id
     */
    private Integer groupId;

    /**
     * 获取用户分组id
     * @return 用户分组id
     */
    public Integer getUserGroupId() {
        return userGroupId;
    }

    /**
     * 设置用户分组id
     * @param userGroupId 用户分组id
     */
    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
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
     * 获取分组id
     * @return 分组id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置分组id
     * @param groupId 分组id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

}