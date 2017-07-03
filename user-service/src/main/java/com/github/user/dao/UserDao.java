package com.github.user.dao;

import com.github.user.entity.User;

public interface UserDao {

    User getByUserId(int userId);
}
