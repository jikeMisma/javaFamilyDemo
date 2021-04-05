package com.mzc.BehavioralModel.ObserverPattern;

/**
 * 调用的场景类
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.ObserverPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/1 9:31
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/1 9:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Client {
    public static void main(String[] args) {
        //将三个观察者生产出来
        Observer liSi = new LiSi();
        Observer wangSi = new WangSi();
        Observer liuSi = new LiuSi();
        //定义出韩非子
        HanFeiZi hanFeiZi = new HanFeiZi();
        //有三个人在观察韩非子
        hanFeiZi.addObservable(liSi);
        hanFeiZi.addObservable(wangSi);
        hanFeiZi.addObservable(liuSi);
        //然后我们看看韩非子干了什么
        hanFeiZi.havaBreakfast();
        hanFeiZi.haveFun();
    }
}