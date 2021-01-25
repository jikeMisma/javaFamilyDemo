package com.mzc.web.controller;

import com.mzc.pojo.MeetingPub;
import com.mzc.service.MeetingPubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MaZhiCheng
 * @date 2021/1/24 - 14:15
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Controller
@RequestMapping("meeting")
public class MeetingPubController {

    @Autowired
    private MeetingPubService meetingPubService;
    /**
     * 根据会议code查询会议信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "{pcode}",method = RequestMethod.GET)
    public MeetingPub findByPcod(@PathVariable("pcode") String pcode){

        return meetingPubService.findByPcode(pcode);

    }
}
