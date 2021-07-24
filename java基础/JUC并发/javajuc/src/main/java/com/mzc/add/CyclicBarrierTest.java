package com.mzc.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 20:26
 * @motto ����ʫ�����Ի�
 * @���͵�ַ https://blog.csdn.net/mzc_love
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        /**
         * ����7�������ٻ�����
         */
        //�ٻ�������߳�
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() ->{
            System.out.println("�ٻ������ɹ���");
        });
        for (int i = 1; i <= 7 ; i++) {
            final int temp = i;
            //lambda�ܲ�����i��
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "�ռ�" + temp + "������");
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
