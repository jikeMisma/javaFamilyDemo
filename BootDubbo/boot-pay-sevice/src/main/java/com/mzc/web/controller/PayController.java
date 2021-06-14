package com.mzc.web.controller;

import com.mzc.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MaZhiCheng
 * @date 2021/1/25 - 18:45
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Controller
@RequestMapping("pay")
public class PayController {

    @Autowired
    private PayService payService;

    /**
     * 根据用户id查询余额接口
     */
    @ResponseBody
    @RequestMapping(value = "account/{uid}", method = RequestMethod.GET)
    public String account(@PathVariable("uid") String uid) {
        return payService.account(uid);

    }

}
