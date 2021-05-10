package com.mzc.StructuralModel.ProxyPattern.GeneralAgent;

/**
 * 游戏者
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.ProxyPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/6 17:27
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/6 17:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class GamePlayer implements IGamePlayer {

    private String  name = "";
    //通过构造函数传递名称
    public GamePlayer(String _name){
        this.name = _name;
    }
    @Override
    public void login(String user, String passward) {
        System.out.println("登录名为【" + user + "】的用户" + this.name + "登录成功！");
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + "在打怪!");
    }

    @Override
    public void upload() {
        System.out.println(this.name + "有升了一级！");
    }
}