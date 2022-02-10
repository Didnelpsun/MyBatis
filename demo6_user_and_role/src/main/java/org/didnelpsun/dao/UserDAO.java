// UserDAO.java
package org.didnelpsun.dao;

import org.didnelpsun.entity.User;

import java.util.List;

public interface UserDAO {
    // 查询所有用户
    List<User> selectAllUsers();
    // 查询一个用户
    User selectUser(Integer id);
    // 查询用户与对应角色
    List<User> selectAllUserRoles();
}
