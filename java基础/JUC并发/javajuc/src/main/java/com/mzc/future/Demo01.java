package com.mzc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * �ļ�����
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.future
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 17:07
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 17:07
 * @UpdateRemark: The modified content
 * ���Ʋ��� EPG ����������
 * ��׼���� 2020/04/07
 * �ܼ����ڲ�
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
    �첽���ã�����Ajax
    �첽ִ�У�
        �ɹ��ص�
        ʧ�ܻص�
 */
public class Demo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //û�з���ֵ��runAsync�첽�ص�
//        CompletableFuture<Void> completableFuture =CompletableFuture.runAsync(() ->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "==>runAsync(Void)");
//        });
//        System.out.println("1111");
//        completableFuture.get();//��ȡִ�н��

        //�з���ֵ��supplyAsync �첽�ص�
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println(Thread.currentThread().getName() + "==>supplyAsync(Integer)");
            int i = 10/0;
            return 1024;
        });
        Integer integer = completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t);
            System.out.println("u=>" + u);
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 233;
        }).get();

        System.out.println(integer);


    }
}
