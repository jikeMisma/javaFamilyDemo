package com.mzc.StructuralModel.ProxyPattern.GeneralAgent;

/**
 * 游戏代练者（代理类）
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.StructuralModel.ProxyPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/6 17:53
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/6 17:53
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class GamePlayerProxy implements IGamePlayer {
    private IGamePlayer gamePlayer = null;

    //通过构造函数传递对于谁进行代练
    public GamePlayerProxy(IGamePlayer _gameplayer) {
        this.gamePlayer = _gameplayer;
    }

    //代练登录
    @Override
    public void login(String user, String passward) {
        this.gamePlayer.login(user, passward);
    }

    //代练杀怪
    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    //代练升级
    @Override
    public void upload() {
        this.gamePlayer.upload();
    }
    //代练杀怪

}