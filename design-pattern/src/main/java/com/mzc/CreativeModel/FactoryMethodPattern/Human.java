package com.mzc.CreativeModel.FactoryMethodPattern;

/**
 * 人类总称
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.CreativeModel.FactoryMethodPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/8 16:24
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/8 16:24
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public interface Human {
    //每个人种的皮肤都有相应的颜色
    public void getColor();
    //人类会说话
    public void talk();
}