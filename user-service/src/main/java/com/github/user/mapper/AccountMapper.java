package com.github.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.mybatisq.Query;
import com.github.user.entity.Account;

@Mapper
public interface AccountMapper {

    int count(Query<AccountTable> query);

    List<Account> select(Query<AccountTable> query);

    int insert(Account account);

    int update(Account account);

    int delete(@Param("userId") Integer userId);

}