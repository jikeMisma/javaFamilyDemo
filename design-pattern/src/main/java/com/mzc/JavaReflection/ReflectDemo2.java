package com.mzc.JavaReflection;

import com.mzc.JavaReflection.domain.Persion;

import java.lang.reflect.Field;

/**
 * @author MaZhiCheng
 * @date 2021/6/14 - 21:45
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
public class ReflectDemo2 {

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
         1. 获取成员变量们
         * Field[] getFields() ：获取所有public修饰的成员变量
         * Field getField(String name)   获取指定名称的 public修饰的成员变量
         * Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
         * Field getDeclaredField(String name)
         */

        //1.Field[] getFields()
        Field[] fields = personClass.getFields();//获取所有public修饰的成员变量
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("-----------------------");
        //2.Field getField(String name)
        Field a = personClass.getField("a");
        //获取变量a的值
        Persion p = new Persion();
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p,158);
        System.out.println(p);

        System.out.println("================");
        //3.Field[] getDeclaredFields() 获取所有field,不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2 = d.get(p);
        System.out.println(value2);
    }
}
