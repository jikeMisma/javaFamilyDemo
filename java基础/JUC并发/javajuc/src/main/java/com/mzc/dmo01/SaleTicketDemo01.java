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

/**
 * �����Ķ��߳̿�������˾�еĿ���
 * �߳̾���һ����������Դ�࣬û���κθ�������
 *      1.���ԡ�����
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        //����������̲߳���ͬһ����Դ��,����Դ�ඪ���߳�
        Ticket ticket = new Ticket();

        //@FunctionalInterface:����ʽ�ӿڣ�jdk1.8�����ʹ��labda���ʽ()->{����}
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

//��Դ�࣬OOP
class Ticket{

    //���ԡ�����
    private int number = 30;

    //��Ʊ�ķ�ʽ
    //synchronized���ʣ����У���
    public synchronized void sale(){
        if(number > 0){
            System.out.println(Thread.currentThread().getName() + "������" + (number--) + "��Ʊ��ʣ�ࣺ" + number);
        }
    }

}
