package com.github.user.service.repository.impl;

import com.github.user.service.entity.Log;
import com.github.user.service.mapper.LogMapper;
import com.github.user.service.mapper.LogTable;
import com.github.user.service.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class LogRepositoryImpl implements LogRepository {

    @Autowired
    private LogMapper logMapper;

    @Override
    public Log getByLogId(String logId) {
        LogTable l = LogTable.log;
        List<Log> logs = logMapper.select(l.query().where(l.log_id.eq(logId)).limit(1));
        return logs.size() == 0 ? null : logs.get(0);
    }

    @Override
    public void create(Log log) {
        logMapper.insert(log);
    }
}
