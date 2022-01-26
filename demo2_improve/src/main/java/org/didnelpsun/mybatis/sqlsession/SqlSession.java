package org.didnelpsun.mybatis.sqlsession;

// 自定义MyBatis中与数据库交互的核心接口，用于与DAO进行交互

public interface SqlSession {
    // 根据参数创建一个代理对象，使用泛型，参数为DAO的接口字节码
    <T> T getMapper(Class<T> daoInterfaceClass);

    // 释放资源方法
    void close();
}
