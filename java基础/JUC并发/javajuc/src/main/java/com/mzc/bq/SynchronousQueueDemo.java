package com.mzc.bq;

/**
 * �ļ�����
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.bq
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/30 18:38
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/30 18:38
 * @UpdateRemark: The modified content
 * ���Ʋ��� EPG ����������
 * ��׼���� 2020/04/07
 * �ܼ����ڲ�
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * ͬ������
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();//ͬ������
        new Thread(() ->{

            try {
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "put 1");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "put 2");
                blockingQueue.put("3");
                System.out.println(Thread.currentThread().getName() + "put 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() +"ȡ����"+ blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() +"ȡ����"+ blockingQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() +"ȡ����"+ blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();

    }
}
