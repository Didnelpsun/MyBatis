// DefaultSqlSession.java
package org.didnelpsun.mybatis.sqlsession;

import org.didnelpsun.mybatis.cfg.Configuration;
import org.springframework.cglib.proxy.Proxy;
import org.didnelpsun.mybatis.sqlsession.MapperProxy;

public class DefaultSqlSession implements SqlSession {
    private Configuration config;

    public Configuration getConfig() {
        return config;
    }

    public void setConfig(Configuration config) {
        this.config = config;
    }

    public DefaultSqlSession(Configuration config){};

    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new CLass[]{daoInterfaceClass}, new MapperProxy())
        return null;
    }

    @Override
    public void close() {
    }
}
