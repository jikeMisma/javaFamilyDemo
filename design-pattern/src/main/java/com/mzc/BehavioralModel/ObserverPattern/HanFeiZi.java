package com.mzc.BehavioralModel.ObserverPattern;

import java.util.ArrayList;

/**
 * 被观察者的实现类
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.ObserverPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/1 9:18
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/1 9:18
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class HanFeiZi implements Observable,IHanFeiZi {

    //定义一个可变长数组，存放所有的观察者
    private ArrayList<Observer> observableList = new ArrayList<Observer>();

    //添加观察者
    @Override
    public void addObservable(Observer observer) {
        this.observableList.add(observer);
    }

    //删除观察者
    @Override
    public void deleteObservable(Observer observer) {
        this.observableList.remove(observer);
    }

    //通知所有观察者
    @Override
    public void notifyObservable(String context) {
        for(Observer observer:observableList){
            observer.update(context);
        }
    }

    //韩非子开始吃饭
    @Override
    public void havaBreakfast() {
        System.out.println("韩非子：我要开始吃饭了！");
        this.notifyObservable("韩非子在吃饭！");
    }

    //韩非子开始娱乐
    @Override
    public void haveFun() {
        System.out.println("韩非子：我要开始娱乐了！");
        this.notifyObservable("韩非子在娱乐！");

    }
}