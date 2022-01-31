package org.didnelpsun.dao;

import org.didnelpsun.entity.User;
import org.didnelpsun.entity.Query;

import java.util.List;

public interface UserDAO {
    // 查询所有用户
    List<User> selectAllUsers();
    // 查询一个用户
    User selectUser(Integer id);
    // 根据用户名模糊查询用户
    List<User> selectUsersByName(String name);
    // 根据查询条件对象Query混合模糊查询
    List<User> selectUsersByQuery(Query query);
    // 根据条件查询
    List<User> selectUsersByCondition(User user);
    // 根据ID范围查询
    List<User> selectUsersInIDs(Query query);
}
