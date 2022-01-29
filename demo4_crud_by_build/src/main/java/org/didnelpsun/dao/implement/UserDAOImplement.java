package org.didnelpsun.dao.implement;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.didnelpsun.dao.UserDAO;
import org.didnelpsun.entity.User;

public class UserDAOImplement implements UserDAO {

    // 定义一个私有SqlSession工厂
    private SqlSessionFactory factory;

    public void setFactroy(SqlSessionFactory factory){
        this.factory = factory;
    }

    public SqlSessionFactory getFactory(){
        return this.factory;
    }

    public UserDAOImplement(SqlSessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<User> selectAllUsers() {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法实现查询列表
        // 参数就是能获取配置信息的key，即在resources/org/didnelpsun/dao/UserDAO.xml中的配置信息
        // key为对应的mapper标签的namespace属性"org.didnelpsun.dao.UserDAO"+对应的标签id属性
        List<User> users = session.selectList("org.didnelpsun.dao.UserDAO.selectAllUsers");
        // 3.释放资源
        session.close();
        return users;
    }

    @Override
    public void deleteUser(Integer id) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法
        session.delete("org.didnelpsun.dao.UserDAO.deleteUser", id);
        // 3.提交事务
        session.commit();
        // 4.释放资源
        session.close();
    }

    @Override
    public Integer getUsersSum() {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法实现
        Integer sum = session.selectOne("org.didnelpsun.dao.UserDAO.getUsersSum");
        // 3.释放资源
        session.close();
        return sum;
    }

    @Override
    public void insertUser(User user) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法
        session.insert("org.didnelpsun.dao.UserDAO.insertUser", user);
        // 3.提交事务
        session.commit();
        // 4.释放资源
        session.close();
    }

    @Override
    public User selectUser(Integer id) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法实现
        User user = session.selectOne("org.didnelpsun.dao.UserDAO.selectUser", id);
        // 3.释放资源
        session.close();
        return user;
    }

    @Override
    public List<User> selectUsersByName(String name) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法实现
        List<User> users = session.selectList("org.didnelpsun.dao.UserDAO.selectUsersByName", name);
        // 3.释放资源
        session.close();
        return users;
    }

    @Override
    public void updateUser(User user) {
        // 1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        // 2.调用SqlSession中的方法
        session.update("org.didnelpsun.dao.UserDAO.updateUser", user);
        // 3.提交事务
        session.commit();
        // 4.释放资源
        session.close();
    }

}
