package com.mzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mzc.pojo.TGoods;
import com.mzc.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jikemisma
 * @since 2021-06-27
 */
public interface TGoodsMapper extends BaseMapper<TGoods> {

    //获取商品对象
    List<GoodsVo> findGoodVo();
}
