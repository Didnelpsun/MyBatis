// AppTest.java
package org.didnelpsun;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.didnelpsun.dao.AccountDAO;
import org.didnelpsun.dao.UserDAO;
import org.didnelpsun.entity.Account;
import org.didnelpsun.entity.AccountUser;
import org.didnelpsun.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
    private InputStream in;
    private SqlSession session;
    private UserDAO userDAO;
    private AccountDAO accountDAO;

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
        accountDAO = session.getMapper(AccountDAO.class);
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
//        testSelectAllAccounts();
//        testSelectAccount();
//        testSelectAllAccountUsers();
        testSelectAllUsers();
    }

    // 测试查询所有用户
    public void testSelectAllUsers() {
        List<User> users = userDAO.selectAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
            for (Account account : user.getAccounts()){
                System.out.println(account.toString());
            }
        }
    }

    // 测试查询用户
    public void testSelectUser() {
        User user = userDAO.selectUser(1);
        System.out.println(user.toString());
    }

    // 测试查询所有账户
    public void testSelectAllAccounts(){
        List<Account> accounts = accountDAO.selectAllAccounts();
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }

    // 测试查询账户
    public void testSelectAccount() {
        Account account = accountDAO.selectAccount(1);
        System.out.println(account.toString());
    }

    // 测试查询账户与用户
    public void testSelectAllAccountUsers(){
        // List<AccountUser> accountUsers = accountDAO.selectAllAccountUsers();
        List<Account> accountUsers = accountDAO.selectAllAccountUsers();
        for (Account accountUser : accountUsers) {
            System.out.println(accountUser.toString());
        }
    }
}