package com.mzc.BehavioralModel.ObserverPattern;

/**
 * 被观察者
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.ObserverPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/1 9:14
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/1 9:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public interface Observable {

    //增加一个被观察者
    public void addObservable(Observer observer);
    //删除一个被观察者
    public void deleteObservable(Observer observer);
    //发生改变，通知观察者
    public void notifyObservable(String context);

}
