package com.github.user.client.service;

import com.github.user.api.AccountApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 账号服务
 */
@FeignClient(name = "user-service")
interface AccountService extends AccountApi {

}
