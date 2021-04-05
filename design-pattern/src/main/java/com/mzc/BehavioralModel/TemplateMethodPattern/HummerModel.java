package com.mzc.BehavioralModel.TemplateMethodPattern;

/**
 * 抽象悍马模型
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.TemplateMethodPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/2 8:52
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/2 8:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public abstract class HummerModel {
    //模型首先要被发动起来，不论是手摇还是电力
    protected abstract void start();
    //能发动起来，也能停下
    protected abstract void stop();
    //喇叭可以发出声音
    protected abstract void alarm();
    //引擎会隆隆响
    protected abstract void engineBoom();

    //模板方法，用来执行基本的方法(汽车模型的启动)
    //模板方法一般都是用来将基本方法串成流程的，不需要子类重写，所以一般使用final修饰
    final public void run(){
        //发动汽车
        this.start();
        //引擎开始轰鸣
        this.engineBoom();;
        //喇叭是否轰鸣是可以控制的
        if(this.isAlarm()){
            this.alarm();
        }

        //到达目的地就停车
        this.stop();
    }

    //钩子方法，默认喇叭是会响的
    protected boolean isAlarm(){
        return true;
    }

}