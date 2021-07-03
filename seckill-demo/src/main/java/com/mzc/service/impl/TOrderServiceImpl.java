package com.mzc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mzc.mapper.TOrderMapper;
import com.mzc.pojo.TOrder;
import com.mzc.pojo.TSeckillGoods;
import com.mzc.pojo.TSeckillOrder;
import com.mzc.pojo.TUser;
import com.mzc.service.TOrderService;
import com.mzc.service.TSeckillGoodsService;
import com.mzc.service.TSeckillOrderService;
import com.mzc.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jikemisma
 * @since 2021-06-27
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {

    @Autowired
    private TSeckillGoodsService seckillGoodsService;

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    private TSeckillOrderService seckillOrderService;

    @Override
    public TOrder seckill(TUser user, GoodsVo goods) {
        //1.秒杀商品减库存
        TSeckillGoods seckillgoods = seckillGoodsService.getOne(new QueryWrapper<TSeckillGoods>().eq("goods_id", goods.getId()));
        seckillgoods.setStockCount(seckillgoods.getStockCount()-1);
        seckillGoodsService.updateById(seckillgoods);

        //2.生成订单
        TOrder order = new TOrder();
        order.setUserId(user.getId());
        order.setGoodsId(goods.getId());
        order.setDeliveryAddId(0l);
        order.setGoodsName(goods.getGoodsName());
        order.setGoodsCount(1);
        order.setGoodsPrice(seckillgoods.getSeckillPrice());
        order.setOrderChannel(1);
        order.setStatus(0);
        order.setCreateDate(new Date());
        orderMapper.insert(order);

        //3.生成秒杀订单
        TSeckillOrder seckillOrder = new TSeckillOrder();
        seckillOrder.setUserId(user.getId());
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setGoodsId(goods.getId());
        seckillOrderService.save(seckillOrder);

        return order;
    }
}
