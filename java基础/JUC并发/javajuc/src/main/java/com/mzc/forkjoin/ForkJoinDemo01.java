package com.mzc.forkjoin;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: javajuc
 * @Package: com.mzc.forkjoin
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/7/31 16:25
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/7/31 16:25
 * @UpdateRemark: The modified content
 * 编制部门 EPG 代码质量组
 * 批准日期 2020/04/07
 * 密级：内部
 * @Version: 1.0* @Version: 1.0
 * *
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved* Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/

/*
    求和计算的任务

    如何使用ForkJoin
        1.forkjoinpool，通过他来执行
        2.计算任务forkjoinpool.execute(ForkJoinTask<?> task)
        3.计算类继承RecursiveTask
 */
public class ForkJoinDemo01 extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    //临界值
    private Long temp = 10000L;

    public ForkJoinDemo01(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public void test() {

    }


    public static void main(String[] args) {

    }

    //计算方法
    @Override
    protected Long compute() {
        if ((end - start) < temp){
            Long sun = 0L;
            for (Long i = start; i <= end ; i++) {
                sun += i;
            }
            return sun;
        }else {//分支合并计算,forkjoin
           Long middle = (start + end) / 2 ;//中间值
            ForkJoinDemo01 task1 = new ForkJoinDemo01(start, middle);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoinDemo01 task2 = new ForkJoinDemo01(middle, end);
            task1.fork();//拆分任务，把任务压入线程队列

            return task1.join()+task2.join();
        }
    }
}
