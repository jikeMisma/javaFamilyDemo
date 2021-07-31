package com.mzc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �ļ�����
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.pool
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/30 18:55
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/30 18:55
 * @UpdateRemark: The modified content
 * ���Ʋ��� EPG ����������
 * ��׼���� 2020/04/07
 * �ܼ����ڲ�
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
 * Executors:�����࣬���󷽷�
 * ʹ�����̳߳�֮��ʹ���̳߳ش����߳�
 */
public class Demo01 {

    public static void main(String[] args) {
//        ExecutorService threadpool = Executors.newSingleThreadExecutor();//�����߳�
//          ExecutorService threadpool = Executors.newFixedThreadPool(5);//����һ���̶����̳߳ش�С
        ExecutorService threadpool = Executors.newCachedThreadPool();//�������ģ���ǿ��ǿ����������

        try {
            for (int i = 0; i < 100; i++) {
                threadpool.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "��ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�̳߳����꣬����������ر��̳߳�
            threadpool.shutdown();
        }
    }
}
