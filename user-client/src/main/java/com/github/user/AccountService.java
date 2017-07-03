package com.github.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.github.AccountApi;

import feign.hystrix.FallbackFactory;

@FeignClient(name = "user-service", fallbackFactory = AccountFallback.class)
interface AccountService extends AccountApi {

}

@Component
class AccountFallback implements FallbackFactory<AccountService> {

    private AccountService accountService;
    
    public AccountFallback() {
        accountService = new AccountService() {
            
            @Override
            public String login() {
               return "你好，服务挂了";
            }
        };
    }
    
    @Override
    public AccountService create(Throwable cause) {
        return accountService;
    }
}

