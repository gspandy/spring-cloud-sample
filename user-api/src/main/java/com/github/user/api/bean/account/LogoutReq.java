package com.github.user.api.bean.account;

import com.github.user.api.bean.UserApiReq;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 登出请求
 */
public class LogoutReq extends UserApiReq {

    /**
     * 访问令牌
     */
    @NotNull
    @Size(min = 1)
    private String accessToken;

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
}
