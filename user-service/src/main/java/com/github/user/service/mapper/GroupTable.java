package com.github.user.service.mapper;

import com.github.mybatisq.Column;
import com.github.mybatisq.Join;
import com.github.mybatisq.Query;
import com.github.mybatisq.Table;

public class GroupTable extends Table {

    private GroupTable() {
        super("group", "g");
    }

    public static final GroupTable group = new GroupTable();

    public Query<GroupTable> query() {
        return new Query<>(group);
    }

    public <T extends Table> Join<GroupTable, T> inner(T table) {
        return new Join<>("inner", this, table);
    }

    /**
     * 分组id
     */
    public Column<GroupTable, Integer> group_id = new Column<>("group_id");

    /**
     * 组名
     */
    public Column<GroupTable, Integer> group_name = new Column<>("group_name");
}