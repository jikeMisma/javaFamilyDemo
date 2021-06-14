package com.mzc.CustomAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.CustomAnnotation
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/8 13:58
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/8 13:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class TestAnnotation {
    public static void main(String[] args) {
        try {
            //获取Student的class对象
            Class stuClass = Class.forName("com.mzc.CustomAnnotation.Student");
            //说明一下，这里形参不能写成Integer.class，应写为int.class
            Method stuMethod = stuClass.getMethod("study", int.class);

            if (stuMethod.isAnnotationPresent(CherryAnnotation.class)) {
                System.out.println("Student类上配置了CherryAnnotation注解！");
                //获取该元素上指定类型的注解
                CherryAnnotation cherryAnnotation = stuMethod.getAnnotation(CherryAnnotation.class);
                //返回方法上所有注解
                Annotation[] annotations = stuMethod.getAnnotations();
                System.out.println(Arrays.toString(annotations));
                System.out.println("name:" + cherryAnnotation.name() + ",age:" + cherryAnnotation.age() + ",score:" + cherryAnnotation.score()[0]);
            } else {
                System.out.println("Student类没有配置CherryAnnotation注解！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}