package com.github.user.service.repository.impl;

import com.github.user.service.mapper.UserGroupMapper;
import com.github.user.service.repository.UserGroupRepository;
import com.github.user.service.entity.UserGroup;
import com.github.user.service.mapper.UserGroupTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class UserGroupRepositoryImpl implements UserGroupRepository {

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Override
    public List<UserGroup> listByUserId(int userId) {
        UserGroupTable ug = UserGroupTable.user_group;
        return userGroupMapper.select(ug.query().where(ug.user_id.eq(userId)));
    }
}
