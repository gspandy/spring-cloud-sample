package com.github.user.service.repository.impl;

import com.github.user.service.entity.Permission;
import com.github.user.service.mapper.PermissionMapper;
import com.github.user.service.repository.PermissionRepository;
import com.github.user.service.mapper.PermissionTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
class PermissionRepositoryImpl implements PermissionRepository {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> listByUserId(int userId) {
        PermissionTable p = PermissionTable.permission;
        return permissionMapper.select(p.query().where(p.user_id.eq(userId)));
    }

    @Override
    public List<Permission> listByGroupIds(Collection<Integer> groupIds) {
        if (groupIds == null || groupIds.size() == 0) return new ArrayList<>();
        PermissionTable p = PermissionTable.permission;
        return permissionMapper.select(p.query().where(p.group_id.in(groupIds)));
    }
}
