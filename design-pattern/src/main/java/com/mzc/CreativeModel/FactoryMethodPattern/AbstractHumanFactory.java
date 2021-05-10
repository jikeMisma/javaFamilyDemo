package com.mzc.CreativeModel.FactoryMethodPattern;

/**
 * 抽象人类创建工厂
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.CreativeModel.FactoryMethodPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/8 16:30
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/8 16:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}