package com.mzc.dmo01;

/**
 * @author MaZhiCheng
 * @date 2021/7/23 - 23:02
 * @motto ����ʫ�����Ի�
 * @���͵�ַ https://blog.csdn.net/mzc_love
 */

/**
 * ��������Ʊ����
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �����Ķ��߳̿�������˾�еĿ���
 * �߳̾���һ����������Դ�࣬û���κθ�������
 *      1.���ԡ�����
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

//Lock��

/**
 * lock������
 *      1.new ReentrantLock
 *      2.lock.lock() ����
 *      3.fnally�н���
 */
class Ticket1{

    //���ԡ�����
    private int number = 30;

    Lock lock = new ReentrantLock();

    //
    public synchronized void sale(){

        lock.lock();//��������
        try {
            //ҵ�����
            if(number > 0){
                System.out.println(Thread.currentThread().getName() + "������" + (number--) + "��Ʊ��ʣ�ࣺ" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//����
        }
    }

}
