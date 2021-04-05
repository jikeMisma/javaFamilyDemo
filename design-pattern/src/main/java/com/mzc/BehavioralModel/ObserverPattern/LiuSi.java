package com.mzc.BehavioralModel.ObserverPattern;

/**
 * 观察者
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.ObserverPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/1 9:46
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/1 9:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class LiuSi implements Observer {
    //刘斯是个观察者，一看到韩非子有活动就开始痛哭
    @Override
    public void update(String context) {
        System.out.println("刘斯：观察到韩非子有活动，开始向老板汇报了...");
        this.cry(context);
        System.out.println("刘斯：哭死了...");
    }

    private void cry(String reportContext){
        System.out.println("刘斯：因为" + reportContext+"所以我难过啊！");

    }
}