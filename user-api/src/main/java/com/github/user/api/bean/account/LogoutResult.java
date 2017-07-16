package com.github.user.api.bean.account;

import com.github.user.api.bean.UserApiResult;

import java.util.Date;

/**
 * 登出结果
 */
public class LogoutResult extends UserApiResult {

    /**
     * 登出日期
     */
    private Date logoutDate;

    /**
     * 获取登出日期
     * @return 登出日期
     */
    public Date getLogoutDate() {
        return logoutDate;
    }

    /**
     * 设置登出日期
     * @param logoutDate 登出日期
     */
    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }
}
