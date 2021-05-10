package com.mzc.BehavioralModel.StrategyPattern;

/**
 * 赵云使用计谋
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.StrategyPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/9 14:23
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/9 14:23
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class ZhaoYun {
    //赵云出场了，他根据诸葛亮给他的交代，依次拆开妙计
    public static void main(String[] args) {
        Context context;
        //刚到吴国的时候拆开第一个
        System.out.println("---刚到吴国的时候拆开第一个---");
        context = new Context(new BackDoor());//拿到妙计
        context.operate();//开始执行
        System.out.println("\n\n\n");
        //刘备乐不思蜀，拆了第二个
        System.out.println("---刘备乐不思蜀，拆了第二个---");
        context = new Context(new GivenGreenLight());//拿到妙计
        context.operate();//开始执行
        System.out.println("\n\n\n");
        //孙权追兵来了，咋办，拆第三个？
        System.out.println("---孙权追兵来了，咋办，拆第三个---");
        context = new Context(new BlockEnemy());//拿到妙计
        context.operate();//开始执行
        System.out.println("\n\n\n");

    }
}