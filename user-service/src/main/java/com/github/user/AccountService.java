package com.github.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

import com.github.AccountApi;
import com.github.user.mapper.UserMapper;
import com.github.user.mapper.UserTable;

@RestController
@RefreshScope
public class AccountService implements AccountApi {
    
    @Value("${login-message}")
    private String loginMessage;
    
    @Value("${server.port}")
    private String serverPort;
    
    @Autowired
    private UserMapper userMapper;

    public String login() {
        UserTable u = UserTable.user;
        userMapper.selectWithDept(u.query()
                .where(u.uid.eq(1))
                .where(u.createDate.between(new Date(), new Date()))
                .orderBy(u.uid.asc())
                .orderBy(u.createDate.desc())
                .skip(5)
                .limit(10));
        return loginMessage + serverPort;
    }
}
