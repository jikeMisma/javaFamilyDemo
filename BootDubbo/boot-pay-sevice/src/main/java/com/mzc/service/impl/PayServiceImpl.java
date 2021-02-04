package com.mzc.service.impl;

import com.mzc.mapper.PayAccountMapper;
import com.mzc.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MaZhiCheng
 * @date 2021/1/25 - 18:44
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Service
@com.alibaba.dubbo.config.annotation.Service
public class PayServiceImpl implements PayService {


    @Autowired
    private PayAccountMapper payAccountMapper;


    @Override
    public String account(String uid) {
        return uid+"账户余额为:"+payAccountMapper.findAccountById(uid)+"元";
    }
}
