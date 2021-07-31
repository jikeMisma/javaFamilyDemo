package com.mzc.t_volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.t_volatile
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 21:28
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 21:28
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
    加volatile不保证原子性
 */
public class VDemo02 {

    //原子类的Intger
    private static volatile AtomicInteger num = new AtomicInteger();

    private static void add(){
//        num++;//不是一个原子性的操作
        num.getAndIncrement();//底层是 CAS
    }

    public static void main(String[] args) {

        //理论上结果应该为20000
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);

    }
}
