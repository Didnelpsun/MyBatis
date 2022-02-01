package org.didnelpsun.dao;

import org.didnelpsun.entity.Account;
// import org.didnelpsun.entity.AccountUser;

import java.util.List;

public interface AccountDAO {
    // 查询所有账户
    List<Account> selectAllAccounts();
    // 查询一个账户
    Account selectAccount(Integer id);
    // 查询所有账户并包括对应用户信息
//    List<AccountUser> selectAllAccountUsers();
    List<Account> selectAllAccountUsers();
}
