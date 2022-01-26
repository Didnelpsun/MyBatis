package org.didnelpsun.mybatis.io;

import java.io.InputStream;

// 使用类加载器读取文件

public class Resources {
    // 根据传入参数获取一个字节输入流
    public static InputStream getResourceAsStream(String filePath){
        // Resources.class获取当前类的字节码
        // getClassLoader获取该类字节码的类加载器
        // getResourceAsStream(filePath)根据类加载器和对应的相对路径读取文件
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
    
}
