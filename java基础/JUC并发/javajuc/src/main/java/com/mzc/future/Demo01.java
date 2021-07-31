package com.mzc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 文件描述
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
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
    异步调用：类似Ajax
    异步执行，
        成功回调
        失败回调
 */
public class Demo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //没有返回值的runAsync异步回调
//        CompletableFuture<Void> completableFuture =CompletableFuture.runAsync(() ->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "==>runAsync(Void)");
//        });
//        System.out.println("1111");
//        completableFuture.get();//获取执行结果

        //有返回值的supplyAsync 异步回调
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
