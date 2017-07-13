package com.github.user.mapper;

import com.github.mybatisq.Column;
import com.github.mybatisq.Join;
import com.github.mybatisq.Query;
import com.github.mybatisq.Table;

public class AccountTable extends Table {

    private AccountTable() {
        super("account", "a");
    }

    public static final AccountTable account = new AccountTable();

    public Query<AccountTable> query() {
        return new Query<>(account);
    }

    public <T extends Table> Join<AccountTable, T> inner(T table) {
        return new Join<>("inner", this, table);
    }

    /**
     * 账号id
     */
    public Column<AccountTable, Integer> user_id = new Column<>("user_id");

    /**
     * 用户名
     */
    public Column<AccountTable, String> username = new Column<>("username");

    /**
     * 密码
     */
    public Column<AccountTable, String> password = new Column<>("password");

    /**
     * 最近登录日期
     */
    public Column<AccountTable, java.util.Date> last_login_date = new Column<>("last_login_date");
}