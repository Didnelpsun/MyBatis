package org.didnelpsun.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.didnelpsun.entity.Account;
// import org.didnelpsun.entity.AccountUser;

import java.util.List;

public interface AccountDAO {
    // 查询所有账户
    @Select("select * from account")
    List<Account> selectAllAccounts();
    // 查询一个账户
    @Select("select * from account where id=#{id}")
    Account selectAccount(Integer id);
    // 查询所有账户并包括对应用户信息
    @Select("select * from account")
    @Results(value = {
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "userid", property = "userid"),
            @Result(column = "money", property = "money"),
            @Result(property = "user", column = "userid", one=@One(
                    select="org.didnelpsun.dao.UserDAO.selectUser", fetchType= FetchType.EAGER
            ))
    })
    List<Account> selectAllAccountUsers();
    // 根据用户id查询所有账户
    @Select("select * from account where userid = #{userid}")
    List<Account> selectAllAccountsByUserID(Integer userid);
}
