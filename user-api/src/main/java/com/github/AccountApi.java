package com.github;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/account")
public interface AccountApi {

    @RequestMapping("/login")
    String login();
}