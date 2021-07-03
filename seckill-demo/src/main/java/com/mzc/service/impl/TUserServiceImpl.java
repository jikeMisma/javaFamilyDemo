package com.mzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mzc.exception.GlobalException;
import com.mzc.mapper.TUserMapper;
import com.mzc.pojo.TUser;
import com.mzc.service.TUserService;
import com.mzc.utils.CookieUtil;
import com.mzc.utils.MD5Util;
import com.mzc.utils.UUIDUtil;
import com.mzc.utils.ValidatorUtil;
import com.mzc.vo.LoginVo;
import com.mzc.vo.RespBean;
import com.mzc.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jikemisma
 * @since 2021-06-24
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {


    @Autowired
    private TUserMapper userMapper;


    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 登录
     *
     * @param loginVo
     * @return
     */
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
//        //非空判断
//        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
//            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
//        }
//        //判断是不是手机号码
//        if(!ValidatorUtil.isMobile(mobile)){
//            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//        }
        //根据手机号获取用户
        TUser user = userMapper.selectById(mobile);
        if(null == user){
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        //判断密码是否正确
        System.out.println("/////////"+MD5Util.FromPassToDbPass(password,user.getSlat()));
        if(!MD5Util.FromPassToDbPass(password,user.getSlat()).equals(user.getPassword())){
            //return RespBean.error(RespBeanEnum.LOGIN_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }

        //生成cookie
        String ticket = UUIDUtil.uuid();
        //将用户信息存入redis中
        redisTemplate.opsForValue().set("user:"+ticket,user);
//        request.getSession().setAttribute(ticket,user);
        CookieUtil.setCookie(request,response,"userTicket",ticket);
        return RespBean.success(ticket);

    }

    @Override
    public TUser getUserByCookie(String userticket, HttpServletRequest request, HttpServletResponse response) {
        if(StringUtils.isEmpty(userticket)){
            return  null;
        }
        TUser user = (TUser)redisTemplate.opsForValue().get("user:" + userticket);
        if(user != null){
            CookieUtil.setCookie(request,response,"userTicket",userticket);
        }
        return user;
    }
}
