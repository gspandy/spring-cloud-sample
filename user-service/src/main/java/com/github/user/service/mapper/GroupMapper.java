package com.github.user.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.mybatisq.Query;
import com.github.user.service.entity.Group;

@Mapper
public interface GroupMapper {

    int count(Query<GroupTable> query);

    List<Group> select(Query<GroupTable> query);

    int insert(Group group);

    int update(Group group);

    int delete(@Param("groupId") Integer groupId);

}