package com.mzc.controller;

import com.mzc.service.TUserService;
import com.mzc.vo.LoginVo;
import com.mzc.vo.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author MaZhiCheng
 * @date 2021/6/24 - 21:47
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
@Api(description = "秒杀系统登录接口")
@Controller
@RequestMapping("login")
@Slf4j
public class LoginController {

    @Autowired
    private TUserService userService;

    @ApiOperation(value = "秒杀系统跳转至登录")
    @RequestMapping("tologin")
    public String tologin() {
        return "login";
    }

    /**
     * 登录功能
     * @param loginVo
     * @return
     */
    @RequestMapping("doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        log.info("{}", loginVo);
        return userService.doLogin(loginVo,request,response);

    }
}
