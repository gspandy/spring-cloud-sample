package com.github.user.mapper;

import com.github.mybatisq.Column;
import com.github.mybatisq.Join;
import com.github.mybatisq.Query;
import com.github.mybatisq.Table;

public class UserGroupTable extends Table {

    private UserGroupTable() {
        super("user_group", "u0");
    }

    public static final UserGroupTable user_group = new UserGroupTable();

    public Query<UserGroupTable> query() {
        return new Query<>(user_group);
    }

    public <T extends Table> Join<UserGroupTable, T> inner(T table) {
        return new Join<>("inner", this, table);
    }

    /**
     * 用户分组id
     */
    public Column<UserGroupTable, Integer> user_group_id = new Column<>("user_group_id");

    /**
     * 用户id
     */
    public Column<UserGroupTable, Integer> user_id = new Column<>("user_id");

    /**
     * 分组id
     */
    public Column<UserGroupTable, Integer> group_id = new Column<>("group_id");
}