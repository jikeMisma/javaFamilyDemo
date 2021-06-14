package com.mzc.StructuralModel.ProxyPattern.GeneralAgent;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.StructuralModel.ProxyPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/6 17:46
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/6 17:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Client {
    public static void main(String[] args) {
        //定义一个玩家
        IGamePlayer player = new GamePlayer("张三");

        //然后在定义一个代练者
        IGamePlayer proxy = new GamePlayerProxy(player);
        //开始打游戏，记下时间戳
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        System.out.println("开始时间是" + date);
        proxy.login("zhangsan", "password");
        //开始打怪
        proxy.killBoss();
        //升级
        proxy.upload();
        //游戏结束时间
        String dateend = df.format(new Date());
        System.out.println("结束时间是：" + dateend);
    }
}