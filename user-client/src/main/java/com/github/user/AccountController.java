package com.github.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acct")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @RequestMapping("/lg")
    public String login() {
        return accountService.login();
    }
}
