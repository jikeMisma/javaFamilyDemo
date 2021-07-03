package com.mzc.controller;

import com.mzc.pojo.TUser;
import com.mzc.service.TGoodsService;
import com.mzc.service.TUserService;
import com.mzc.vo.GoodsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


/**
 * @author MaZhiCheng
 * @date 2021/6/26 - 13:02
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Api(description = "商品部分接口")
@Controller
@RequestMapping("/goods")
public class GoodsController {


    @Autowired
    private TUserService userService;
    @Autowired
    private TGoodsService goodsService;


    /**
     * 跳转到商品列表页面
     * @param model
     * @return
     */
    @ApiOperation(value = "跳转到商品列表页面")
    @RequestMapping("toList")
    public String toList(Model model,TUser user){

        //session获取用户信息，如果用户不存在或者没有登录跳转到登录页面
//        if(StringUtils.isEmpty(ticket)){
//            return "login";
//        }
//        TUser user =(TUser) session.getAttribute(ticket);
//        TUser user = userService.getUserByCookie(ticket, request, response);
//        if(null == user){
//            return "login";
//        }

        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }

    @ApiOperation(value = "查询商品详情")
    @RequestMapping("toDetail/{goodsId}")
    public String toDetail(Model model, TUser user, @PathVariable Long goodsId){

        model.addAttribute("user",user);
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();

        //秒杀状态，默认为0
        int secKillStatus = 0;
        //秒杀倒计时
        int remainSeconds = 0;

        //当前时间在开始时间之前->秒杀未开始
        if(nowDate.before(startDate)){
            secKillStatus = 0;
            remainSeconds = ((int)((startDate.getTime() - nowDate.getTime()) / 1000));
        }else if(nowDate.after(endDate)){//秒杀已经结束
            secKillStatus = 2;
            remainSeconds = -1;
        }else{
            //秒杀中
            secKillStatus = 1;
            remainSeconds = 0;
        }

        model.addAttribute("remainSeconds",remainSeconds);
        model.addAttribute("secKillStatus",secKillStatus);
        model.addAttribute("goods",goodsVo);
        return "goodsDetail";
    }
}
