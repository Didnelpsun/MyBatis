package org.didnelpsun.mybatis.cfg;

import java.util.Map;

// 自定义MyBaits的配置类

public class Configuration {
    // 属性为对应的连接属性
    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String,Mapper> mappers;

    
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String,Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String,Mapper> mappers) {
        // 将所有的mapper配置全部加进去
        this.mappers.putAll(mappers);;
    }

}
