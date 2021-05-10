package com.mzc.BehavioralModel.StrategyPattern;

/**
 * 第三妙计 孙夫人断后
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.StrategyPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/9 14:18
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/9 14:18
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class BlockEnemy implements Istrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后挡住追兵！");
    }
}