package com.github.user.service.mapper;

import com.github.mybatisq.Column;
import com.github.mybatisq.Join;
import com.github.mybatisq.Query;
import com.github.mybatisq.Table;

public class UserTable extends Table {

    private UserTable() {
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
    public Column<UserTable, Integer> user_id = new Column<>("user_id");

    /**
     * 姓名
     */
    public Column<UserTable, String> name = new Column<>("name");

    /**
     * Email
     */
    public Column<UserTable, String> email = new Column<>("email");

    /**
     * 工号
     */
    public Column<UserTable, String> employee_no = new Column<>("employee_no");

    /**
     * 出生日期
     */
    public Column<UserTable, java.util.Date> birthday = new Column<>("birthday");
}