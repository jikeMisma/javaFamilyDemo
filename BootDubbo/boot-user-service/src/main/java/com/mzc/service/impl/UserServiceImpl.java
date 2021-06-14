package com.mzc.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mzc.mapper.UserMapper;
import com.mzc.pojo.User;
import com.mzc.service.PayService;
import com.mzc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaZhiCheng
 * @date 2021/1/23 - 15:15
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Service
@com.alibaba.dubbo.config.annotation.Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    //负载均衡机制
    @Reference(check = false, loadbalance = "roundRobin ")
    private PayService payService;

    @Override
    public User findById(String id) {

        //根据用户id查询用户余额，该服务在apy-service中
        String account = payService.account(id);
        User user = userMapper.findById(id);
        user.setAccount(account);
        return user;
    }
}
