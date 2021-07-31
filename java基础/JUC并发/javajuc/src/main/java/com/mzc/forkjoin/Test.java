package com.mzc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.forkjoin
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 16:46
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 16:46
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1();//时间：5813
//        test2();//时间：5813
        test3();//时间：479
    }

    //普通程序猿
    public static void test1(){
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 10_0000_0000 ; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" +sum+ "时间：" + (end - start));
    }

    //会使用forkjoin
    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo01(0L,10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);//提交任务
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum=" +sum+ "时间：" + (end - start));
    }

    public static void test3(){
        long start = System.currentTimeMillis();
        //stream并行流
        long sum = LongStream.rangeClosed(0L, 10_0000_0000).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum=" +sum+ "时间：" + (end - start));
    }
}
