package com.mzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mzc.mapper.TGoodsMapper;
import com.mzc.pojo.TGoods;
import com.mzc.service.TGoodsService;
import com.mzc.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jikemisma
 * @since 2021-06-27
 */
@Service
public class TGoodsServiceImpl extends ServiceImpl<TGoodsMapper, TGoods> implements TGoodsService {


    @Autowired
    private TGoodsMapper goodsMapper;

    /**
     * 获取商品列表
     * @return
     */
    @Override
    public List<GoodsVo> findGoodsVo() {
        return goodsMapper.findGoodVo();
    }

    @Override
    public GoodsVo findGoodsVoByGoodsId(Long goodsId) {
        return goodsMapper.findGoodsByGoodsId(goodsId);
    }
}
