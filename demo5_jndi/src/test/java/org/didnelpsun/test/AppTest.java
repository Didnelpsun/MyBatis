package org.didnelpsun.test;

import org.didnelpsun.dao.UserDao;
import org.didnelpsun.entity.Query;
import org.didnelpsun.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AppTest {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
       // sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testSelectAllUsers(){
        //5.执行查询所有方法
        List<User> users = userDao.selectAllUsers();
        for(User user : users){
            System.out.println(user);
        }

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setName("autocommit");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前："+user);
        //5.执行保存方法
        userDao.insertUser(user);
        System.out.println("保存操作之后："+user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(50);
        user.setName("更新");
        user.setAddress("北京市顺义区");
        user.setSex("女");
        user.setBirthday(new Date());

        //5.执行保存方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDeleteUser(){
        //5.执行删除方法
        userDao.deleteUser(48);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testSelectUser(){
        //5.执行查询一个方法
        User  user = userDao.selectUser(50);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testSelectUsersByName(){
        //5.执行查询一个方法
        List<User> users = userDao.selectUsersByName("%王%");
        for(User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testSelectSum(){
        //5.执行查询一个方法
        int count = userDao.selectSum();
        System.out.println(count);
    }


    /**
     * 测试使用Query作为查询条件
     */
    @Test
    public void testFindByVo(){
        Query query = new Query();
        User user = new User();
        user.setName("%王%");
        query.setUser(user);
        //5.执行查询一个方法
        List<User> users = userDao.selectUsersByQuery(query);
        for(User u : users){
            System.out.println(u);
        }
    }
}
