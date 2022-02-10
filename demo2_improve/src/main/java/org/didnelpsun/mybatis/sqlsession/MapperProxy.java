// MapperProxy.java
package org.didnelpsun.mybatis.sqlsession;

import java.lang.reflect.Method;
import java.util.Map;
import org.didnelpsun.mybatis.cfg.Mapper;

import org.springframework.cglib.proxy.InvocationHandler;

public class MapperProxy implements InvocationHandler {

    // map的key是全限定类名+方法名
    private Map<String,Mapper> mappers;

    public MapperProxy(Map<String,Mapper> mappers){
        this.mappers = mappers;
    }

    // 用于增强方法，即调用FindAllUser方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取方法名
        String methodName = method.getName();
        // 获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        // 组合成key
        String key = className + "." + methodName;
        // 获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        // 判断是否存在
        if(mapper == null){
            throw new IllegalArgumentException("传入参数有误");
        }
        // 调用工具类查询所有
        return null;
    }
    
}
