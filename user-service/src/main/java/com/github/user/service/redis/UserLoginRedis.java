package com.github.user.service.redis;

import com.github.user.service.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginRedis {

    @Autowired
    private RedisTemplate<String, UserLogin> redis;

    public void set(UserLogin userLogin) {
        redis.opsForValue().set(userLogin.getAccessToken(), userLogin);
    }

    public void del(String accessToken) {
        redis.delete(accessToken);
    }

    public UserLogin get(String accessToken) {
        return redis.opsForValue().get(accessToken);
    }
}
