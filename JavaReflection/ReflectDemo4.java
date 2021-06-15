package com.mzc.JavaReflection;

import com.mzc.JavaReflection.domain.Persion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author MaZhiCheng
 * @date 2021/6/14 - 21:45
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
public class ReflectDemo4 {

    /**
     1. 获取成员变量们
         * Field[] getFields() ：获取所有public修饰的成员变量
         * Field getField(String name)   获取指定名称的 public修饰的成员变量
         * Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
         * Field getDeclaredField(String name)
     2. 获取构造方法们
         * Constructor<?>[] getConstructors()
         * Constructor<T> getConstructor(类<?>... parameterTypes)
         * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
         * Constructor<?>[] getDeclaredConstructors()
     3. 获取成员方法们：
         * Method[] getMethods()
         * Method getMethod(String name, 类<?>... parameterTypes)

         * Method[] getDeclaredMethods()
         * Method getDeclaredMethod(String name, 类<?>... parameterTypes)

     4. 获取全类名
         * String getName()
     */

    public static void main(String[] args) throws Exception {
        //0.获取Persion的class对象
        Class personClass = Persion.class;
        /*
        3. 获取成员方法们：
         * Method[] getMethods()
         * Method getMethod(String name, 类<?>... parameterTypes)

         * Method[] getDeclaredMethods()
         * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         */

        //Method[] getMethods()
        //获取指定名称的方法
        Method eat_methed = personClass.getMethod("eat");
        Persion p = new Persion();
        //执行方法
        eat_methed.invoke(p);

        Method eat_methed1 = personClass.getMethod("eat", String.class);
        eat_methed1.invoke(p,"饭");

    }
}
