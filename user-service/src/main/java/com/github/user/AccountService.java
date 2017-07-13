package com.github.user;

import com.github.AccountApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class AccountService implements AccountApi {
    
    @Value("${login-message}")
    private String loginMessage;
    
    @Value("${server.port}")
    private String serverPort;

    public String login() {
        return loginMessage + serverPort;
    }
}
