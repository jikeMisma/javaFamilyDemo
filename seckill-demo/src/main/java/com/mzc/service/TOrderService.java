package com.mzc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mzc.pojo.TOrder;
import com.mzc.pojo.TUser;
import com.mzc.vo.GoodsVo;
import sun.security.pkcs11.wrapper.CK_TOKEN_INFO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jikemisma
 * @since 2021-06-27
 */
public interface TOrderService extends IService<TOrder> {

    //秒杀
    TOrder seckill(TUser user, GoodsVo goods);
}
