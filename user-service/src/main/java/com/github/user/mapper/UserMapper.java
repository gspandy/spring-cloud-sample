package com.github.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.mybatisq.Query;
import com.github.user.entity.User;
import com.github.user.entity.UserWithDept;

@Mapper
public interface UserMapper {

    int count(Query<UserTable> query);

    List<User> select(Query<UserTable> query);
    
    List<UserWithDept> selectWithDept(Query<UserTable> query);

    int insert(User user);

    int update(User user);

    int delete(@Param("uid") Integer uid);

}