package com.mzc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MaZhiCheng
 * @date 2021/6/24 - 16:11
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Controller
@RequestMapping("demo")
public class DemoController {

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("hello")
    public String hello(Model model){
        model.addAttribute("name","马志成");
        return "hello";
    }
}
