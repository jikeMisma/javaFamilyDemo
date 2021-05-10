package com.mzc.BehavioralModel.StrategyPattern;

/**
 * 第一妙计，乔国老开后门
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.StrategyPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/1 17:57
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/1 17:57
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class BackDoor implements Istrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力...");
    }
}