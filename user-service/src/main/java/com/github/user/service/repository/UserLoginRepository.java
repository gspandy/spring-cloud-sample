package com.github.user.service.repository;

import com.github.user.service.entity.UserLogin;

public interface UserLoginRepository {

    void create(UserLogin userLogin);

    void deleteByAccessToken(String accessToken);

    UserLogin getByAccessToken(String accessToken);
}
