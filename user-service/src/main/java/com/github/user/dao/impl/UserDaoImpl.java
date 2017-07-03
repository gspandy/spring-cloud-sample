package com.github.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.user.dao.UserDao;
import com.github.user.entity.User;
import com.github.user.mapper.UserMapper;
import com.github.user.mapper.UserTable;

@Repository
class UserDaoImpl implements UserDao {
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUserId(int userId) {
        UserTable u = UserTable.user;
        List<User> users = userMapper.select(u.query().where(u.uid.eq(userId)).limit(1));
        return users.size() == 0 ? null : users.get(0);
    }

}
