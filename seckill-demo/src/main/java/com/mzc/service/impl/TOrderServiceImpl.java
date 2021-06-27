package com.mzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mzc.mapper.TOrderMapper;
import com.mzc.pojo.TOrder;
import com.mzc.service.TOrderService;
import org.springframework.stereotype.Service;

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

}
