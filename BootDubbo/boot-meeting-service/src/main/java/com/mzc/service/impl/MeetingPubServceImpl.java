package com.mzc.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mzc.mapper.MeetingMapper;
import com.mzc.pojo.MeetingPub;
import com.mzc.pojo.User;
import com.mzc.service.MeetingPubService;
import com.mzc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaZhiCheng
 * @date 2021/1/24 - 14:12
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Service
public class MeetingPubServceImpl implements MeetingPubService {


    @Autowired
    private MeetingMapper meetingMapper;

    @Reference//应用服务（消费注册中心中的对应服务）
    private UserService userService;

    @Override
    public MeetingPub findByPcode(String pcode) {
        //查询数据库
        MeetingPub meetingPub = meetingMapper.findByPcode(pcode);

        //调用服务完成服务的消费
        System.out.println("Uid====>:"+meetingPub.getUid());
        User user = userService.findById(meetingPub.getUid());
        meetingPub.setUser(user);

        return meetingPub;
    }
}
