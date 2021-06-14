package com.mzc.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MaZhiCheng
 * @date 2021/1/22 - 16:07
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Data
public class MettingPub implements Serializable {

    /*主键id*/
    private String id;

    /*会议编号*/
    private String pcode;

    /*会议标题*/
    private String title;

    /*会议内容*/
    private String content;

    /*发布人员，在用户信息服务中*/
    private String Uid;
    private User user;
}
