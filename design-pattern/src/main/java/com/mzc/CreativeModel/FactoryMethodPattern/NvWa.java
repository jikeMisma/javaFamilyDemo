package com.mzc.CreativeModel.FactoryMethodPattern;

/**
 * 女娲类
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.CreativeModel.FactoryMethodPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/8 16:36
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/8 16:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class NvWa {

    public static void main(String[] args) {
        //生命阴阳八卦炉
        AbstractHumanFactory YinYangLu = new HumanFactory();
        //女娲第一次造人，火候不足，于是白人产生
        System.out.println("--造出的第一批人是白色人种--");
        Human whiteHuman = YinYangLu.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        //女娲第二次造人，火候过足，于是黑人产生
        System.out.println("--造出的第二批人是黑色人种--");
        Human blackHuman = YinYangLu.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
        //女娲第三次造人，火候刚刚好，于是黄色人种产生
        System.out.println("--造出的第三批人是黄色人种--");
        Human yellowHuman = YinYangLu.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }
}