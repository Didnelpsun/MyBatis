package org.didnelpsun;

//import static org.junit.Assert.assertTrue;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.didnelpsun.dao.UserDAO;
import org.didnelpsun.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppTest2 {
    private InputStream in;
    private SqlSessionFactory factory;

    // 测试之前执行
    @Before
    public void init() {
        // 1.读取配置文件
        in = null;
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 测试之后执行
    @After
    public void destroy() throws Exception {
        // 6.释放资源
        assert in != null;
        in.close();
    }

    @Test
    public void Test() {
        testSecondCache();
    }

    public void testSecondCache(){
        SqlSession session1 = factory.openSession();
        UserDAO userDAO1 = session1.getMapper(UserDAO.class);
        User user1 = userDAO1.selectUser(1);
        System.out.println(user1);
        session1.close();
        // 关闭session1的一级缓存
        SqlSession session2 = factory.openSession();
        UserDAO userDAO2 = session2.getMapper(UserDAO.class);
        User user2 = userDAO2.selectUser(1);
        System.out.println(user2);
        session2.close();
        System.out.println(user1 == user2);
    }
}