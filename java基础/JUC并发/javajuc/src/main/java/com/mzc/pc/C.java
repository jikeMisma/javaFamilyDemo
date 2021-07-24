package com.mzc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 10:35
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

/**
 * Condition实现精准通知唤醒
 *
 * A执行完调用B，B执行完调用C，C执行完调用A
 */
public class C {

    public static void main(String[] args) {

        Data3 data = new Data3();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        },"C").start();
    }
}

class Data3{//资源列Lock

    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    private int number = 1;//1A,2B,3C


    public void printA(){
        lock.lock();
        try {
            //业务，判断->执行->通知
            while (number != 1){
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"AAAAA");
            //唤醒，唤醒指定的人,B
            number = 2;
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            //业务，判断->执行->通知
            while (number != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"BBBBB");
            //唤醒，唤醒指定的人,B
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            //业务，判断->执行->通知
            while (number != 3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"CCCCC");
            //唤醒，唤醒指定的人,B
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
