package com.mzc.add;

import java.util.concurrent.CountDownLatch;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 16:49
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

//计数器
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //总数是6,必须要执行任务的时候，再使用
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "Go out!");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零，然后再向下执行
        System.out.println("Close door!");

    }
}
