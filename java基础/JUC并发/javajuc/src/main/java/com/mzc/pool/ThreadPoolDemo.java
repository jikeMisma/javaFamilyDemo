package com.mzc.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �ļ�����
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.pool
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/30 19:17
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/30 19:17
 * @UpdateRemark: The modified content
 * ���Ʋ��� EPG ����������
 * ��׼���� 2020/04/07
 * �ܼ����ڲ�
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ThreadPoolDemo {

    /*
        �̳߳ؾܾ����ԣ�4��
        1. new ThreadPoolExecutor.AbortPolicy());//�ܾ����ԣ��������ˣ������˽��������������ҵ���׳��쳣
        2. new ThreadPoolExecutor.CallerRunsPolicy());//�ܾ����ԣ�������ȥ����
        3. new ThreadPoolExecutor.DiscardPolicy());//�ܾ����ԣ��������˶������񣬲����׳��쳣��
        4. new ThreadPoolExecutor.DiscardPolicy());//�ܾ����ԣ��������˳��Ժ�����ľ�����Ҳ�����׳��쳣



     */
    public static void main(String[] args) {

        //��ȡ����CPU����
        System.out.println(Runtime.getRuntime().availableProcessors());

        //�Զ����̳߳�
        /*
            ����̳߳ظ���ζ��壿
                1.CPU�ܼ��ͣ����˵�CPU���Ǽ������Ա���cpu��Ч�����
                2.Io�ܼ��ͣ��жϳ�����ʮ�ֺ�IO���̣߳������߳�����������Ϳɣ���ʹ�ù�����һ�����ú����߳���Ϊʮ��ռ����Դ�̵߳�2��
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,//�����߳���
                5,//����߳�����
                3,//��ʱ�ȴ�ʱ��
                TimeUnit.SECONDS,//��ʱ�ȴ�ʱ�䵥λ
                new LinkedBlockingQueue<>(3),//��������
                Executors.defaultThreadFactory(),//�����̹߳���
                new ThreadPoolExecutor.DiscardPolicy());//�ܾ����ԣ��������˳��Ժ�����ľ�����Ҳ�����׳��쳣

        try {
            //�����أ�maxpoolsize+queue���׳��쳣��RejectedExecutionException
            for (int i = 1; i <= 9; i++) {
                threadPoolExecutor.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "��ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //�̳߳����꣬����������ر��̳߳�
            threadPoolExecutor.shutdown();
        }
    }
}
