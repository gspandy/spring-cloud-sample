package com.github.user.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.mybatisq.Query;
import com.github.user.service.entity.UserGroup;

@Mapper
public interface UserGroupMapper {

    int count(Query<UserGroupTable> query);

    List<UserGroup> select(Query<UserGroupTable> query);

    int insert(UserGroup userGroup);

    int update(UserGroup userGroup);

    int delete(@Param("userGroupId") Integer userGroupId);

}