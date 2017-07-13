package com.github.user.entity;

/**
 * 分组
 */
public class Group {

    /**
     * 分组id
     */
    private Integer groupId;

    /**
     * 组名
     */
    private Integer groupName;

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

    /**
     * 获取组名
     * @return 组名
     */
    public Integer getGroupName() {
        return groupName;
    }

    /**
     * 设置组名
     * @param groupName 组名
     */
    public void setGroupName(Integer groupName) {
        this.groupName = groupName;
    }

}