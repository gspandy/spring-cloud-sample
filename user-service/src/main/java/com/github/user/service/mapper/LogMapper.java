package com.github.user.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.mybatisq.Query;
import com.github.user.service.entity.Log;

@Mapper
public interface LogMapper {

    int count(Query<LogTable> query);

    List<Log> select(Query<LogTable> query);

    int insert(Log log);

    int update(Log log);

    int delete(@Param("logId") String logId);

}