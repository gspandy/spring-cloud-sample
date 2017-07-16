package com.github.user.service.repository.impl;

import com.github.user.service.entity.User;
import com.github.user.service.mapper.UserTable;
import com.github.user.service.repository.UserRepository;
import com.github.user.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUserId(int userId) {
        UserTable u = UserTable.user;
        List<User> users = userMapper.select(u.query().where(u.user_id.eq(userId)).limit(1));
        return users.size() == 0 ? null : users.get(0);
    }
}
