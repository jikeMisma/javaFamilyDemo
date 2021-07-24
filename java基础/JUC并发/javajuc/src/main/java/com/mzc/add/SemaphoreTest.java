package com.mzc.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 20:37
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

/**
 * 六个车抢3个车位的例子
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        //线程数量：停车位,限流的时候可以使用
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() ->{
                //  acquire():得到
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位！");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "离开车位！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放
                }
                //  release():释放
            },String.valueOf(i)).start();
        }

    }
}
