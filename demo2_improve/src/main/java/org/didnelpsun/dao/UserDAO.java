package org.didnelpsun.dao;

import org.didnelpsun.entity.User;

import java.util.List;

public interface UserDAO {
    // 查询所有用户
    List<User> FindAllUsers();
}
