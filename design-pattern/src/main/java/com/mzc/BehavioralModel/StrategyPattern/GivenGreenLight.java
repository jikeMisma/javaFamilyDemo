package com.mzc.BehavioralModel.StrategyPattern;

/**
 * 第二妙计 吴国开绿灯
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.StrategyPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/1 17:59
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/1 17:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class GivenGreenLight implements Istrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开绿灯，放行！");

    }
}