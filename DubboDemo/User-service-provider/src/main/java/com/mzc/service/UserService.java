package com.mzc.service;

import com.mzc.pojo.User;

/**
 * @author MaZhiCheng
 * @date 2021/1/22 - 15:55
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
public interface UserService {

    /**
     * 根据用户id查询用户信息
     */

    public User findById(String id);
}
