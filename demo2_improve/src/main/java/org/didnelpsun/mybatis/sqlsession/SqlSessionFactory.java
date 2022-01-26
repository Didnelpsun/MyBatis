package org.didnelpsun.mybatis.sqlsession;

// SqlSession工厂的接口

public interface SqlSessionFactory {
    // 用于打开一个新的SqlSession对象
    public SqlSession openSession();
}
