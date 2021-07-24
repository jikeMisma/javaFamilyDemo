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

/**
 * 真正的多线程开发，公司中的开发
 * 线程就是一个单独的资源类，没有任何负数操作
 *      1.属性、方法
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        //并发：多个线程操作同一个资源类,把资源类丢入线程
        Ticket ticket = new Ticket();

        //@FunctionalInterface:函数式接口，jdk1.8后可以使用labda表达式()->{代码}
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }

        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}

//资源类，OOP
class Ticket{

    //属性、方法
    private int number = 30;

    //买票的方式
    //synchronized本质：队列，锁
    public synchronized void sale(){
        if(number > 0){
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "张票，剩余：" + number);
        }
    }

}
