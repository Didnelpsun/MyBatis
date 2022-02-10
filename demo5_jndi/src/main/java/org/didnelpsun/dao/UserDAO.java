// UserDAO.java
package org.didnelpsun.dao;

import org.didnelpsun.entity.Query;
import org.didnelpsun.entity.User;

import java.util.List;

public interface UserDao {

    // 查询所有用户
    List<User> selectAllUsers();

    // 保存用户
    void insertUser(User user);

    // 更新用户
    void updateUser(User user);

    // 根据Id删除用户
    void deleteUser(Integer Id);

    // 根据id查询用户信息
    //
    User selectUser(Integer Id);

    // 根据名称模糊查询用户信息=
    List<User> selectUsersByName(String name);

    // 查询总用户数
    int selectSum();

    // 根据queryVo中的条件查询用户
    List<User> selectUsersByQuery(Query query);
}
