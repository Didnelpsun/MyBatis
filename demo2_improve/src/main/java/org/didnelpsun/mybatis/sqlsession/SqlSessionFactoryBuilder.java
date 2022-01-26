package org.didnelpsun.mybatis.sqlsession;

import java.io.InputStream;
import org.didnelpsun.mybatis.cfg.Configuration;
import org.didnelpsun.mybatis.utils.XMLConfigBuilder;

// 用于创建一个SqlSessionFactory对象来生产SqlSession

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
