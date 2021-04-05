package com.mzc.BehavioralModel.TemplateMethodPattern;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.TemplateMethodPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/2 9:02
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/2 9:02
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class HummerH2Model extends HummerModel {

    @Override
    public void start() {
        System.out.println("悍马H2发动...");
    }

    @Override
    public void stop() {
        System.out.println("悍马H2停车...");
    }

    @Override
    public void alarm() {
        System.out.println("悍马H2鸣笛...");
    }

    //H2车型默认没有喇叭
    protected boolean isAlarm(){
        return false;
    }

    @Override
    public void engineBoom() {
        System.out.println("悍马H2的引擎声音是这样的...");
    }
}