package org.didnelpsun.dao;

import org.apache.ibatis.annotations.Select;
import org.didnelpsun.entity.User;

import java.util.List;

public interface UserDAO {
    // 查询所有用户
    @Select("select * from user")
    List<User> FindAllUsers();
}
