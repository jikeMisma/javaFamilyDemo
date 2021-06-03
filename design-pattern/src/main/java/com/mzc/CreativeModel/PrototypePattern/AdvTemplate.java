package com.mzc.CreativeModel.PrototypePattern;

/**
 * @author MaZhiCheng
 * @date 2021/6/3 - 22:22
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

/**
 * 广告信息模板代码
 */
public class AdvTemplate {
    //广告信息名称
    private String advSubject = "XX银行国庆信用卡抽奖活动";
    //广告信息内容
    private String advContext = "国庆抽奖活动通知：只要刷卡就送你一百万";

    public String getAdvSubject() {
        return advSubject;
    }

    public void setAdvSubject(String advSubject) {
        this.advSubject = advSubject;
    }

    public String getAdvContext() {
        return advContext;
    }

    public void setAdvContext(String advContext) {
        this.advContext = advContext;
    }
}
