package com.github.user.mapper;

import com.github.mybatisq.Column;
import com.github.mybatisq.Join;
import com.github.mybatisq.Query;
import com.github.mybatisq.Table;

public class UserTable extends Table {

    UserTable() {
        super("user", "u");
    }

    public static final UserTable user = new UserTable();

    public Query<UserTable> query() {
        return new Query<>(user);
    }

    public <T extends Table> Join<UserTable, T> inner(T table) {
        return new Join<>("inner", this, table);
    }

    /**
     * 用户id
     */
    public Column<UserTable, Integer> uid = new Column<>("uid");

    /**
     * 用户名
     */
    public Column<UserTable, String> username = new Column<>("username");

    /**
     * 密码
     */
    public Column<UserTable, String> password = new Column<>("password");

    /**
     * 创建日期
     */
    public Column<UserTable, java.util.Date> createDate = new Column<>("createDate");
}