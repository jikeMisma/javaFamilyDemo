package com.mzc.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 文件描述
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
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright ? 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ThreadPoolDemo {

    /*
        线程池拒绝策略：4种
        1. new ThreadPoolExecutor.AbortPolicy());//拒绝策略，银行满了，还有人进来，不处理这个业务，抛出异常
        2. new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略，哪来的去哪里
        3. new ThreadPoolExecutor.DiscardPolicy());//拒绝策略，队列满了丢掉任务，不会抛出异常，
        4. new ThreadPoolExecutor.DiscardPolicy());//拒绝策略，队列满了尝试和最早的竞争，也不会抛出异常



     */
    public static void main(String[] args) {

        //获取电脑CPU核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        //自定义线程池
        /*
            最大线程池该如何定义？
                1.CPU密集型，几核的CPU就是几，可以保持cpu的效率最高
                2.Io密集型，判断程序中十分耗IO的线程，核心线程数大于这个就可，在使用过程中一般设置核心线程数为十分占用资源线程的2倍
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,//核心线程数
                5,//最大线程数量
                3,//超时等待时长
                TimeUnit.SECONDS,//超时等待时间单位
                new LinkedBlockingQueue<>(3),//阻塞队列
                Executors.defaultThreadFactory(),//创建线程工厂
                new ThreadPoolExecutor.DiscardPolicy());//拒绝策略，队列满了尝试和最早的竞争，也不会抛出异常

        try {
            //最大承载：maxpoolsize+queue，抛出异常：RejectedExecutionException
            for (int i = 1; i <= 9; i++) {
                threadPoolExecutor.execute(() ->{
                    System.out.println(Thread.currentThread().getName() + "：ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadPoolExecutor.shutdown();
        }
    }
}
