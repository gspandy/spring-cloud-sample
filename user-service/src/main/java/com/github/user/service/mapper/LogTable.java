package com.github.user.service.mapper;

import com.github.mybatisq.Column;
import com.github.mybatisq.Join;
import com.github.mybatisq.Query;
import com.github.mybatisq.Table;

public class LogTable extends Table {

    private LogTable() {
        super("log", "l");
    }

    public static final LogTable log = new LogTable();

    public Query<LogTable> query() {
        return new Query<>(log);
    }

    public <T extends Table> Join<LogTable, T> inner(T table) {
        return new Join<>("inner", this, table);
    }

    /**
     * 日志id
     */
    public Column<LogTable, String> log_id = new Column<>("log_id");

    /**
     * 日志类型
     */
    public Column<LogTable, Integer> log_type = new Column<>("log_type");

    /**
     * 操作用户id
     */
    public Column<LogTable, Integer> user_id = new Column<>("user_id");

    /**
     * 日志信息
     */
    public Column<LogTable, String> log_message = new Column<>("log_message");

    /**
     * 日志日期
     */
    public Column<LogTable, java.util.Date> log_date = new Column<>("log_date");
}