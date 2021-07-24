package com.mzc.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author MaZhiCheng
 * @date 2021/7/24 - 20:37
 * @motto ����ʫ�����Ի�
 * @���͵�ַ https://blog.csdn.net/mzc_love
 */

/**
 * ��������3����λ������
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        //�߳�������ͣ��λ,������ʱ�����ʹ��
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() ->{
                //  acquire():�õ�
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "������λ��");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "�뿪��λ��");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//�ͷ�
                }
                //  release():�ͷ�
            },String.valueOf(i)).start();
        }

    }
}
