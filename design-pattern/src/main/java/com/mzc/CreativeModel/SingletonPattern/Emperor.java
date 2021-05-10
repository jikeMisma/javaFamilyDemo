package com.mzc.CreativeModel.SingletonPattern;

/**
 * 皇帝类
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.CreativeModel.SingletonPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/9 9:20
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/9 9:20
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Emperor {
    private static final Emperor empertir = new Emperor();
    //单例模式的无参构造必须为private，约束外界不能通过new的方式创建对象，保持单例的特性
    private Emperor(){

    }
    public static Emperor getInstance(){
        return empertir;
    }

    //皇帝发话了
    public static void say(){
        System.out.println("我是皇帝某某某...");
    }
}