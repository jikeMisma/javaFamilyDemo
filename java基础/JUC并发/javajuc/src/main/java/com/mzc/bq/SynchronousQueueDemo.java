package com.mzc.bq;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.bq
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/30 18:38
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/30 18:38
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();//同步队列
        new Thread(() ->{

            try {
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "put 1");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "put 2");
                blockingQueue.put("3");
                System.out.println(Thread.currentThread().getName() + "put 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() +"取出："+ blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() +"取出："+ blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() +"取出："+ blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();

    }
}
