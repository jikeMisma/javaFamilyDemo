package com.mzc.service.impl;

import com.mzc.pojo.MettingPub;
import com.mzc.pojo.User;
import com.mzc.service.MettingPubService;
import com.mzc.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaZhiCheng
 * @date 2021/1/22 - 16:11
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Service
public class MettingPubServiceImpl implements MettingPubService {

    @Autowired
    private UserService userService;

    @Override
    public MettingPub findByPcode(String pcode) {

        //查询数据
        MettingPub m = new MettingPub();
        m.setPcode(pcode);
        m.setId("1001");
        m.setTitle("学习Dubbo");
        m.setContent("dubbo，RPC框架，分布式服务解决方案！");
        m.setUid("123");

        //根据用户id查询用户信息

        System.out.println("远程访问！！");
        User user = userService.findById(m.getUid());
        m.setUser(user);
        //想得到用户信息

        return m;
    }
}
