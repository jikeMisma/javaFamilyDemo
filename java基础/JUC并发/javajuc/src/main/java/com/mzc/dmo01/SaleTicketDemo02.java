package com.mzc.dmo01;

/**
 * @author MaZhiCheng
 * @date 2021/7/23 - 23:02
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

/**
 * 基本的买票例子
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 真正的多线程开发，公司中的开发
 * 线程就是一个单独的资源类，没有任何负数操作
 *      1.属性、方法
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {

        Ticket1 ticket1 = new Ticket1();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket1.sale();
            }

        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket1.sale();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket1.sale();
            }
        },"C").start();
    }
}

//Lock锁

/**
 * lock三部曲
 *      1.new ReentrantLock
 *      2.lock.lock() 加锁
 *      3.fnally中解锁
 */
class Ticket1{

    //属性、方法
    private int number = 30;

    Lock lock = new ReentrantLock();

    //
    public synchronized void sale(){

        lock.lock();//加锁操作
        try {
            //业务代码
            if(number > 0){
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "张票，剩余：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//解锁
        }
    }

}
