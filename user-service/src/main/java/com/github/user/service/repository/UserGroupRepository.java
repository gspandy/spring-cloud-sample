package com.github.user.service.repository;

import com.github.user.service.entity.UserGroup;

import java.util.List;

public interface UserGroupRepository {

    List<UserGroup> listByUserId(int userId);
}
