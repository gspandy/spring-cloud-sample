package com.github.user.service.repository;

import com.github.user.service.entity.Account;

public interface AccountRepository {

    Account getByUsername(String username);

    void update(Account account);
}
