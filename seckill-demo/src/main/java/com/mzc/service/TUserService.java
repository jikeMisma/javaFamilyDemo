package com.mzc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mzc.pojo.TUser;
import com.mzc.vo.LoginVo;
import com.mzc.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jikemisma
 * @since 2021-06-24
 */
public interface TUserService extends IService<TUser> {

    //登录
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    //根据cookie获取用户
    TUser getUserByCookie(String userticket,HttpServletRequest request, HttpServletResponse response);
}
