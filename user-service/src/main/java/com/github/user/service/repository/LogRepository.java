package com.github.user.service.repository;

import com.github.user.service.entity.Log;

public interface LogRepository {

    Log getByLogId(String logId);

    void create(Log log);
}
