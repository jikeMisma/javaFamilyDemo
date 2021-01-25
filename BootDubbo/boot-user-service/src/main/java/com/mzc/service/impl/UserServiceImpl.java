package com.mzc.service.impl;

import com.mzc.mapper.UserMapper;
import com.mzc.pojo.User;
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

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }
}
