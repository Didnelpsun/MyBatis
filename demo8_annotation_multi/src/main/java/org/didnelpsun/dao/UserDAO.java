// UserDAO.java
package org.didnelpsun.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.didnelpsun.entity.User;

import java.util.List;

@CacheNamespace(blocking = true)
public interface UserDAO {
    // 查询所有用户
    @Select("select * from user")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(property = "accounts", column = "id", many = @Many(
                    select = "org.didnelpsun.dao.AccountDAO.selectAllAccountsByUserID", fetchType = FetchType.LAZY
            ))
    })
    List<User> selectAllUsers();
    // 查询一个用户
    @Select("select * from user where id=#{id}")
    User selectUser(Integer id);
}
