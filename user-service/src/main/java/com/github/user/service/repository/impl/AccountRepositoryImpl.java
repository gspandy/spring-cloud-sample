package com.github.user.service.repository.impl;

import com.github.user.service.entity.Account;
import com.github.user.service.mapper.AccountMapper;
import com.github.user.service.mapper.AccountTable;
import com.github.user.service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getByUsername(String username) {
        if (username == null) return null;
        AccountTable a = AccountTable.account;
        List<Account> accounts = accountMapper.select(a.query().where(a.username.eq(username)).limit(1));
        return accounts.size() == 0 ? null : accounts.get(0);
    }

    @Override
    public void update(Account account) {
        accountMapper.update(account);
    }
}
