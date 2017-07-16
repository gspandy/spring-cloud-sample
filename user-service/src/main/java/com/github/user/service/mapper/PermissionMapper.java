package com.github.user.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.mybatisq.Query;
import com.github.user.service.entity.Permission;

@Mapper
public interface PermissionMapper {

    int count(Query<PermissionTable> query);

    List<Permission> select(Query<PermissionTable> query);

    int insert(Permission permission);

    int update(Permission permission);

    int delete(@Param("permissionId") Integer permissionId);

}