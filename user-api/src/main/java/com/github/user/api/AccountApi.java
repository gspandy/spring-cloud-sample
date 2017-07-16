package com.github.user.api;

import com.github.user.api.bean.account.*;
import com.github.user.api.exception.UserApiException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/account")
public interface AccountApi {

    /**
     * 登录
     * @param req 登录请求
     * @return 登录结果
     * @throws UserApiException 用户Api异常
     */
    @RequestMapping("/login")
    LoginResult login(@RequestBody LoginReq req) throws UserApiException;

    /**
     * 登出
     * @param req 登出请求
     * @return 登出结果
     * @throws UserApiException 用户api异常
     */
    @RequestMapping("/logout")
    LogoutResult logout(@RequestBody LogoutReq req) throws UserApiException;

    /**
     * 验证
     * @param req 验证请求
     * @return 验证结果
     * @throws UserApiException 用户api异常
     */
    @RequestMapping("/validate")
    ValidateResult validate(@RequestBody ValidateReq req) throws UserApiException;
}