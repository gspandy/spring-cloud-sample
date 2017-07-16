package com.github.user.service.mapper;

import com.github.mybatisq.Column;
import com.github.mybatisq.Join;
import com.github.mybatisq.Query;
import com.github.mybatisq.Table;

public class PermissionTable extends Table {

    private PermissionTable() {
        super("permission", "p");
    }

    public static final PermissionTable permission = new PermissionTable();

    public Query<PermissionTable> query() {
        return new Query<>(permission);
    }

    public <T extends Table> Join<PermissionTable, T> inner(T table) {
        return new Join<>("inner", this, table);
    }

    /**
     * 权限id
     */
    public Column<PermissionTable, Integer> permission_id = new Column<>("permission_id");

    /**
     * 权限码
     */
    public Column<PermissionTable, Long> permission_code = new Column<>("permission_code");

    /**
     * 组id
     */
    public Column<PermissionTable, Integer> group_id = new Column<>("group_id");

    /**
     * 用户id
     */
    public Column<PermissionTable, Integer> user_id = new Column<>("user_id");
}