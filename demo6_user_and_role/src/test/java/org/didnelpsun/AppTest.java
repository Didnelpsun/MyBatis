package org.didnelpsun;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.didnelpsun.dao.RoleDAO;
import org.didnelpsun.dao.UserDAO;
import org.didnelpsun.entity.Role;
import org.didnelpsun.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
    private InputStream in;
    private SqlSession session;
    private UserDAO userDAO;
    private RoleDAO roleDAO;

    // 测试之前执行
    @Before
    public void init() {
        // 1.读取配置文件
        in = null;
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2.创建SqlSessionFactory工厂
        // SqlSessionFactory不能new
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3.使用工厂生产SqlSession对象
        session = factory.openSession();
        // 4.使用SqlSession创建DAO接口的代理对象
        userDAO = session.getMapper(UserDAO.class);
        roleDAO = session.getMapper(RoleDAO.class);
    }

    // 测试之后执行
    @After
    public void destroy() throws Exception {
        // 提交事务，否则事务会回滚
        session.commit();
        // 6.释放资源
        session.close();
        assert in != null;
        in.close();
    }

    @Test
    public void Test() {
        // 5.使用代理对象执行方法
        // testSelectAllRoles();
        // testSelectAllRoleUsers();
        testSelectAllUserRoles();
    }

    // 测试查询所有用户
    public void testSelectAllUsers() {
        List<User> users = userDAO.selectAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    // 测试查询所有用户与角色
    public void testSelectAllUserRoles() {
        List<User> users = userDAO.selectAllUserRoles();
        for (User user : users) {
            System.out.println(user.toString());
            for(Role role: user.getRoles()){
                System.out.println(role.toString());
            }
        }
    }

    // 测试查询用户
    public void testSelectUser() {
        User user = userDAO.selectUser(1);
        System.out.println(user.toString());
    }

    // 测试查询所有角色
    public void testSelectAllRoles() {
        List<Role> roles = roleDAO.selectAllRoles();
        for (Role role : roles) {
            System.out.println(role.toString());
        }
    }

    // 测试查询所有角色与用户
    public void testSelectAllRoleUsers() {
        List<Role> roles = roleDAO.selectAllRoleUsers();
        for (Role role : roles) {
            System.out.println(role.toString());
            for(User user: role.getUsers()){
                System.out.println(user.toString());
            }
        }
    }
}