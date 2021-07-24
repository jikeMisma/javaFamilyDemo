package com.mzc.add;

import java.util.concurrent.CountDownLatch;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 16:49
 * @motto ����ʫ�����Ի�
 * @���͵�ַ https://blog.csdn.net/mzc_love
 */

//������
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //������6,����Ҫִ�������ʱ����ʹ��
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "Go out!");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//�ȴ����������㣬Ȼ��������ִ��
        System.out.println("Close door!");

    }
}
