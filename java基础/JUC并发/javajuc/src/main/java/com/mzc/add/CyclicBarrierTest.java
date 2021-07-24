package com.mzc.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 20:26
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        /**
         * 集齐7颗龙珠召唤神龙
         */
        //召唤龙珠的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() ->{
            System.out.println("召唤神龙成功！");
        });
        for (int i = 1; i <= 7 ; i++) {
            final int temp = i;
            //lambda能操作到i吗？
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "收集" + temp + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
