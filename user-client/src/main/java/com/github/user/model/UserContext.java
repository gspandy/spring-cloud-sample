package com.github.user.model;

/**
 * 用户上下文
 */
public class UserContext {

    /**
     * 访问令牌
     */
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
