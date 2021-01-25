package com.mzc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MaZhiCheng
 * @date 2021/1/24 - 14:00
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Data
public class MeetingPub implements Serializable {

    /*主键*/
    private String id;
    /*会议code*/
    private String pcode;
    /*会议时间*/
    private Date ptime;
    /*会议名称*/
    private String pname;
    /*会议主题*/
    private String ptitle;
    /*会议区域*/
    private String zone;
    /*会议备注*/
    private String remark;
    /*创建时间*/
    private Date createdate;
    /*会议状态*/
    private Integer status;
    /*关联用户User[id]*/
    private String uid;
    /*关联整个用户对象*/
    private User user;


}
