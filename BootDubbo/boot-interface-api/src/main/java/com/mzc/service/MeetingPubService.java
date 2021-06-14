package com.mzc.service;

import com.mzc.pojo.MeetingPub;

/**
 * @author MaZhiCheng
 * @date 2021/1/24 - 14:10
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
public interface MeetingPubService {


    /**
     * 根据会议id查询会议信息
     */
    public MeetingPub findByPcode(String pcode);
}
