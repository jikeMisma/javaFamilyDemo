package com.mzc.BehavioralModel.ObserverPattern;

/**
 * 观察者接口
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.ObserverPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/1 9:24
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/1 9:24
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public interface Observer {
    //一发现被观察者有动静就要行动起来
    public void update(String context);
}