// AppTest.java
package org.didnelpsun;

//import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// import com.mysql.cj.Query;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.didnelpsun.dao.UserDAO;
import org.didnelpsun.entity.Query;
import org.didnelpsun.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
    private InputStream in;
    private SqlSession session;
    private UserDAO userDAO;

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
        // testInsertUser();
        // testSelectAllUsers();
        // testDeleteUser();
        // System.out.println("更新后：");
        // testSelectAllUsers();
        // testSelectUsersByName();
        // testSelectUsersByCondition();
        testSelectUsersInIDs();
    }

    // 测试查询所有用户
    public void testSelectAllUsers() {
        List<User> users = userDAO.selectAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    // 测试查询用户
    public void testSelectUser() {
        User user = userDAO.selectUser(1);
        System.out.println(user.toString());
    }

    // 测试根据名称查询用户
    public void testSelectUsersByName() {
        List<User> users = userDAO.selectUsersByName("%黄%");
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    // 测试条件查询
    public void testSelectUsersByCondition() {
        User u = new User();
        // u.setSex("男");
        u.setName("%黄%");
        List<User> users = userDAO.selectUsersByCondition(u);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    // 测试ID范围查询
    public void testSelectUsersInIDs(){
        Query query = new Query();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        query.setIds(list);
        List<User> users = userDAO.selectUsersInIDs(query);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}