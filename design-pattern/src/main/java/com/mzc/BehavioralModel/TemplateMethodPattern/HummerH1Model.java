package com.mzc.BehavioralModel.TemplateMethodPattern;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.TemplateMethodPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/2 8:59
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/2 8:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class HummerH1Model extends HummerModel {
    private boolean alarmFlag = true;//要响喇叭

    @Override
    protected void start() {
        System.out.println("悍马H1发动...");
    }

    @Override
    protected void stop() {
        System.out.println("悍马H1停车...");
    }

    @Override
    protected void alarm() {
        System.out.println("悍马H1鸣笛...");
    }

    @Override
    protected void engineBoom() {
        System.out.println("悍马H1的引擎声音是这样的...");
    }

    protected boolean isAlarm(){
        return this.alarmFlag;
    }

    public void setAlarm(boolean isAlarm){
        this.alarmFlag = isAlarm;
    }
}