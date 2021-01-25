package com.mzc.service;

import com.mzc.pojo.User;

/**
 * @author MaZhiCheng
 * @date 2021/1/23 - 15:14
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
public interface UserService {

    User findById(String id);
}
