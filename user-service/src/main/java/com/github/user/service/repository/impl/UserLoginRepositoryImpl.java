package com.github.user.service.repository.impl;

import com.github.user.service.entity.UserLogin;
import com.github.user.service.redis.UserLoginRedis;
import com.github.user.service.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
class UserLoginRepositoryImpl implements UserLoginRepository {

    @Autowired
    private UserLoginRedis userLoginRedis;

    @Override
    public void create(UserLogin userLogin) {
        userLoginRedis.set(userLogin);
    }

    @Override
    public void deleteByAccessToken(String accessToken) {
        userLoginRedis.del(accessToken);
    }

    @Override
    public UserLogin getByAccessToken(String accessToken) {
        return userLoginRedis.get(accessToken);
    }
}
