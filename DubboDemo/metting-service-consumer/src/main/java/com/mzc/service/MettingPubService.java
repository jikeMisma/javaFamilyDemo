package com.mzc.service;

import com.mzc.pojo.MettingPub;

/**
 * @author MaZhiCheng
 * @date 2021/1/22 - 16:10
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
public interface MettingPubService {

    /**
     * 根据会议编号id 查询会议详细信息
     */

    public MettingPub findByPcode(String pcode);
}
