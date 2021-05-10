package com.mzc.CreativeModel.FactoryMethodPattern;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.CreativeModel.FactoryMethodPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/8 16:27
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/8 16:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄色人种的皮肤颜色是黄色的！");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节。");
    }
}