package com.mzc.controller;

import com.mzc.pojo.TUser;
import com.mzc.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author MaZhiCheng
 * @date 2021/6/26 - 13:02
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    private TUserService userService;


    /**
     * 跳转到商品列表页面
     * @param session
     * @param model
     * @param ticket
     * @return
     */
    @RequestMapping("toList")
    public String toList(HttpServletRequest request, HttpServletResponse response, Model model, @CookieValue("userTicket") String ticket){

        //session获取用户信息，如果用户不存在或者没有登录跳转到登录页面
        if(StringUtils.isEmpty(ticket)){
            return "login";
        }
//        TUser user =(TUser) session.getAttribute(ticket);
        TUser user = userService.getUserByCookie(ticket, request, response);
        if(null == user){
            return "login";
        }

        model.addAttribute("user",user);
        return "goodsList";
    }
}
