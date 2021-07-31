package com.mzc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.pool
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/30 18:55
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/30 18:55
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
 * Executors:工具类，三大方法
 * 使用了线程池之后，使用线程池创建线程
 */
public class Demo01 {

    public static void main(String[] args) {
//        ExecutorService threadpool = Executors.newSingleThreadExecutor();//单个线程
//          ExecutorService threadpool = Executors.newFixedThreadPool(5);//创建一个固定的线程池大小
        ExecutorService threadpool = Executors.newCachedThreadPool();//可伸缩的，遇强则强，遇弱则弱

        try {
            for (int i = 0; i < 100; i++) {
                threadpool.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "：ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadpool.shutdown();
        }
    }
}
