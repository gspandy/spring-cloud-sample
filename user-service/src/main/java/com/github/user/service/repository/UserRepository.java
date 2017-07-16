package com.github.user.service.repository;

import com.github.user.service.entity.User;

public interface UserRepository {

    User getByUserId(int userId);
}
