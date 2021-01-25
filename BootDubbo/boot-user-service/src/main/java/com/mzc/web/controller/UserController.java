package com.mzc.web.controller;

import com.mzc.pojo.User;
import com.mzc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author MaZhiCheng
 * @date 2021/1/23 - 15:18
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    //根据用户id查询用户信息

    @ResponseBody
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public User findBuId(@PathVariable("id")  String  id){
        return userService.findById(id);
    }
}
