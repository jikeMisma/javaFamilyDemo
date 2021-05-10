package com.mzc.StructuralModel.ProxyPattern.DynamizAgent;

/**
 * 游戏者接口
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: design-pattern
 * @Package: com.mzc.BehavioralModel.ProxyPattern
 * @Description: note
 * @Author: mazc35591
 * @CreateDate: 2021/4/6 17:25
 * @UpdateUser: mazc35591
 * @UpdateDate: 2021/4/6 17:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public interface IGamePlayer {
    //登录游戏
    public void login(String user, String passward);
    //杀怪，网络游戏的主要特色
    public void killBoss();
    //升级
    public void upload();
}
