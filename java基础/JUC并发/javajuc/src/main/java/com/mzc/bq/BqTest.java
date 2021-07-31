package com.mzc.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * �ļ�����
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.bq
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/28 19:31
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/28 19:31
 * @UpdateRemark: The modified content
 * ���Ʋ��� EPG ����������
 * ��׼���� 2020/04/07
 * �ܼ����ڲ�
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class BqTest {

    public static void main(String[] args) throws InterruptedException {
        //blockingQueue����һ���µĶ���
        test4();
    }

    /**
     * �׳��쳣
     */
    public static void test1(){
        //���еĴ�С
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println("�鿴����Ԫ��:" + blockingQueue.element());

        //������������Ԫ�أ��׳��쳣IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        //ȡ��Ԫ�س�������Ԫ�أ��׳��쳣��java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());

    }

    /**
     * �з���ֵ�����׳��쳣
     */
    public static void test2() {
        //���еĴ�С
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        System.out.println("����Ԫ��" + blockingQueue.peek());

        System.out.println(blockingQueue.offer("d"));//���������Ԫ�����������׳��쳣������false

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());//����null�����׳��쳣
    }

    /**
     * �ȴ�������(һֱ����)
     */
    public static void test3() throws InterruptedException {
        //���еĴ�С
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        //һֱ����
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");//����û��λ���ˣ�һֱ����

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());//û�����Ԫ�أ�һֱ����
    }

    /**
     * �ȴ�������(�ȴ���ʱ)
     */
    public static void test4() throws InterruptedException {
        //���еĴ�С
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d",2, TimeUnit.SECONDS);//�ȴ�������˳�

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        blockingQueue.poll(2,TimeUnit.SECONDS);//���������Ӻ��˳�

    }
}
