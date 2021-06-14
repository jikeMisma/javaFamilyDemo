package com.mzc.service.impl;

import com.mzc.pojo.User;
import com.mzc.service.UserService;

/**
 * @author MaZhiCheng
 * @date 2021/1/22 - 15:56
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
public class UserServiceImpl implements UserService {


    @Override
    public User findById(String id) {

        User user = new User();
        user.setId(id);
        user.setUsername("马志成");
        user.setTelphone("15200371771");
        return user;
    }
}
