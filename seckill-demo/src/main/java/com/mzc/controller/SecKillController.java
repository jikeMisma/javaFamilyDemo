package com.mzc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mzc.pojo.TOrder;
import com.mzc.pojo.TSeckillOrder;
import com.mzc.pojo.TUser;
import com.mzc.service.TGoodsService;
import com.mzc.service.TOrderService;
import com.mzc.service.TSeckillOrderService;
import com.mzc.vo.GoodsVo;
import com.mzc.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MaZhiCheng
 * @date 2021/6/28 - 16:06
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
@Controller
@RequestMapping("seckill")
public class SecKillController {

    @Autowired
    private TGoodsService goodsService;
    @Autowired
    private TSeckillOrderService seckillOrderService;
    @Autowired
    private TOrderService orderService;

    @RequestMapping("doSeckill")
    public String doSeckill(Model model, TUser user,Long goodsId){
        if(user == null){
            return "login";
        }
        model.addAttribute("user",user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断库存
        if(goods.getStockCount() < 1){
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_SOCKET.getMessage());
            return "secKillFail";
        }
        //判断是否重复抢购
        QueryWrapper<TSeckillOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",user.getId()).eq("goods_id",goodsId);
        TSeckillOrder seckillOrder = seckillOrderService.getOne(wrapper);
        if(seckillOrder != null){
            model.addAttribute("errmsg", RespBeanEnum.REPEATE_ERROR.getMessage());
            return "secKillFail";
        }

        TOrder order = orderService.seckill(user, goods);
        model.addAttribute("order",order);
        model.addAttribute("goods",goods);

        return "orderDetail";


    }
}
