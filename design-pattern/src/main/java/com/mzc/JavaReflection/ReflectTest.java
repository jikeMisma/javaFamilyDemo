package com.mzc.JavaReflection;

/**
 * @author MaZhiCheng
 * @date 2021/6/14 - 23:36
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 假设的框架类
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，可以执行任意方法

        /*
            前提：不能改变类的任意代码，可以创建任意类的对象，可以执行任意方法
         */

        //1.加载配置文件
        //1.1 创建Properties对象
        Properties pro = new Properties();
        //1.2加载配置文件
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream rs = classLoader.getResourceAsStream("pro.properties");
        pro.load(rs);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methedNmae = pro.getProperty("methedName");

        //3.加载该类进入内存
        Class<?> cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methedNmae);
        //6.执行方法
        method.invoke(obj);



    }
}
