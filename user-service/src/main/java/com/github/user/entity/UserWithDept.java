package com.github.user.entity;

public class UserWithDept extends User {

    private String deptName;

    /**
     * 获取
     * @return 
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置
     * @param deptName 
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
