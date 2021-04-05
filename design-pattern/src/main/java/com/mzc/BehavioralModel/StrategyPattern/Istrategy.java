package com.mzc.BehavioralModel.StrategyPattern;

/**
 * 锦囊妙计接口
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.StrategyPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/1 17:55
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/1 17:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public interface Istrategy {
    //每个锦囊都是一个可执行的算法
    public void operate();
}
