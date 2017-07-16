package com.github.user.api.bean.account;

import com.github.user.api.bean.UserApiReq;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 登录请求
 */
public class LoginReq extends UserApiReq {

    /**
     * 用户名
     */
    @NotNull
    @Size(min = 1)
    private String username;

    /**
     * 密码
     */
    @NotNull
    @Size(min = 1)
    private String password;

    /**
     * 客户端id
     */
    @NotNull
    @Size(min = 1)
    private String clientId;

    /**
     * 客户端版本
     */
    @NotNull
    @Size(min = 1)
    private String clientVersion;

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
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
}
