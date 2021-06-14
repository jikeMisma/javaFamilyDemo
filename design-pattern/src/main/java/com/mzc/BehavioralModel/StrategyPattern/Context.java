package com.mzc.BehavioralModel.StrategyPattern;

/**
 * 锦囊
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.StrategyPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/9 14:20
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/9 14:20
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Context {

    //构造函数，你要使用哪个妙计？
    private Istrategy straegy;

    public Context(Istrategy _strategy) {
        this.straegy = _strategy;
    }

    //使用计谋，看我出招
    public void operate() {
        this.straegy.operate();
    }
}