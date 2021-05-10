package com.mzc.CreativeModel.FactoryMethodPattern;

/**
 * 白色人种
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.CreativeModel.FactoryMethodPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/8 16:29
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/8 16:29
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class WhiteHuman implements  Human {
    @Override
    public void getColor() {
        System.out.println("白色人种的皮肤颜色是白色的！");
    }

    @Override
    public void talk() {
        System.out.println("白人会说话，一般都是单字节。");
    }
}