package com.mzc.vo;

import com.mzc.pojo.TGoods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品返回对象
 *
 * @author MaZhiCheng
 * @date 2021/6/27 - 22:01
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo extends TGoods {

    /**
     * 秒杀价格
     */
    private BigDecimal seckillPrice;

    /**
     * 库存数量
     */
    private Integer stockCount;

    /**
     * 开始秒杀时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;
}
