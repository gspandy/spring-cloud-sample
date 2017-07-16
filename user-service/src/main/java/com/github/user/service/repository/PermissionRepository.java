package com.github.user.service.repository;

import com.github.user.service.entity.Permission;

import java.util.Collection;
import java.util.List;

public interface PermissionRepository {

    List<Permission> listByUserId(int userId);

    List<Permission> listByGroupIds(Collection<Integer> groupIds);
}
