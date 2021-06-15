package com.mzc.JavaReflection;

import com.mzc.JavaReflection.domain.Persion;

/**
 * @author MaZhiCheng
 * @date 2021/6/14 - 21:26
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
public class ReflectDemo1 {

    /**
     * 获取class对象的三种方式
     *      1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
     * 			* 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
     * 		2. 类名.class：通过类名的属性class获取
     * 			* 多用于参数的传递
     * 		3. 对象.getClass()：getClass()方法在Object类中定义着。
     * 			* 多用于对象的获取字节码的方式
     */
    public static void main(String[] args) throws Exception {
        //1.Class.forName("全类名")
        Class<?> cls1 = Class.forName("com.mzc.JavaReflection.domain.Persion");
        System.out.println(cls1);

        //2.类名.class
        Class cls2 = Persion.class;//true
        System.out.println(cls2);//true

        //3. 对象.getClass()
        Persion persion = new Persion();
        Class cls3 = persion.getClass();
        System.out.println(cls3);


        //验证三张方式的对象是否相同
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
    }
}
