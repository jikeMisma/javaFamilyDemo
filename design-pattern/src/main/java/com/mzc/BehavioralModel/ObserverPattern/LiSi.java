package com.mzc.BehavioralModel.ObserverPattern;

/**
 * 具体的观察者
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.ObserverPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/1 9:26
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/1 9:26
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class LiSi implements Observer {

    //李斯是个观察者，一看到韩非子有活动就向老板汇报
    @Override
    public void update(String context) {
        System.out.println("李斯：观察到韩非子有活动，开始向老板汇报了...");
        this.reportToQinShiHuang(context);
        System.out.println("李斯：汇报完毕...");
    }

    private void reportToQinShiHuang(String reportContext) {
        System.out.println("李斯：报告，秦老板！韩非子有活动了-->" + reportContext);

    }
}