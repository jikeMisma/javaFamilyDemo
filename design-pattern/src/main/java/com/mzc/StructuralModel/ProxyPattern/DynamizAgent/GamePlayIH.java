package com.mzc.StructuralModel.ProxyPattern.DynamizAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.StructuralModel.ProxyPattern.DynamizAgent
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/7 9:09
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/7 9:09
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class GamePlayIH implements InvocationHandler {
    //被代理者
    Class  cls = null;
    //被代理的实例
    Object obj = null;
    //我要代理谁
    public GamePlayIH(Object _obj){
        this.obj = _obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object resoult = method.invoke(this.obj,args);
        //如果是登录方法则发送信息
        if(method.getName().equalsIgnoreCase("login")){
            System.out.println("有人在用我的账号登录！");
        }
        return resoult;
    }
}