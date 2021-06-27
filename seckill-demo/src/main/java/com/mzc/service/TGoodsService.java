package com.mzc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mzc.pojo.TGoods;
import com.mzc.vo.GoodsVo;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jikemisma
 * @since 2021-06-27
 */
public interface TGoodsService extends IService<TGoods> {

    //获取商品列表
    List<GoodsVo> findGoodsVo();
}
