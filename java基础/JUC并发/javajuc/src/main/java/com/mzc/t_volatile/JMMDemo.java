package com.mzc.t_volatile;

import java.util.concurrent.TimeUnit;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.t_volatile
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 21:20
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 21:20
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class JMMDemo {

    //不加volatile，程序就会死循环
    //加volatile，可以保证可见性
    public static volatile int number = 0;

    public static void main(String[] args) {//main线程
        new Thread(() -> {//线程1,对主内存中的变化是不知道的
            while (number == 0){

            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number = 1;
        System.out.println(number);

    }
}
