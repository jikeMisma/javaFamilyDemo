package com.mzc.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.bq
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/28 19:31
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/28 19:31
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class BqTest {

    public static void main(String[] args) throws InterruptedException {
        //blockingQueue不是一个新的东西
        test4();
    }

    /**
     * 抛出异常
     */
    public static void test1(){
        //队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println("查看队首元素:" + blockingQueue.element());

        //超过给定队列元素，抛出异常IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        //取出元素超过定义元素，抛出异常：java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());

    }

    /**
     * 有返回值，不抛出异常
     */
    public static void test2() {
        //队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        System.out.println("队首元素" + blockingQueue.peek());

        System.out.println(blockingQueue.offer("d"));//超过定义的元素数量，不抛出异常，返回false

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//返回null，不抛出异常
    }

    /**
     * 等待，阻塞(一直阻塞)
     */
    public static void test3() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        //一直阻塞
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");//队列没有位置了，一直阻塞

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());//没有这个元素，一直阻塞
    }

    /**
     * 等待，阻塞(等待超时)
     */
    public static void test4() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d",2, TimeUnit.SECONDS);//等待两秒就退出

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        blockingQueue.poll(2,TimeUnit.SECONDS);//超过两秒钟后退出

    }
}
