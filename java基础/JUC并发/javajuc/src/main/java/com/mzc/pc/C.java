package com.mzc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 10:35
 * @motto ����ʫ�����Ի�
 * @���͵�ַ https://blog.csdn.net/mzc_love
 */

/**
 * Conditionʵ�־�׼֪ͨ����
 *
 * Aִ�������B��Bִ�������C��Cִ�������A
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

class Data3{//��Դ��Lock

    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    private int number = 1;//1A,2B,3C


    public void printA(){
        lock.lock();
        try {
            //ҵ���ж�->ִ��->֪ͨ
            while (number != 1){
                //�ȴ�
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"AAAAA");
            //���ѣ�����ָ������,B
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
            //ҵ���ж�->ִ��->֪ͨ
            while (number != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"BBBBB");
            //���ѣ�����ָ������,B
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
            //ҵ���ж�->ִ��->֪ͨ
            while (number != 3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"CCCCC");
            //���ѣ�����ָ������,B
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
