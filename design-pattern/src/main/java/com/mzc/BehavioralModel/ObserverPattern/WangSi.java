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
public class WangSi implements Observer {

    //王斯是个观察者，一看到韩非子有活动就开始高兴的大叫
    @Override
    public void update(String context) {
        System.out.println("王斯：观察到韩非子有活动，自己也开始有动作了...");
        this.Happy(context);
        System.out.println("王斯：高兴死了...");
    }

    private void Happy(String reportContext) {
        System.out.println("王斯：因为" + reportContext + "所以我高兴啊，哈哈哈！");

    }
}