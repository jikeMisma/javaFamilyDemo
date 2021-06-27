package com.mzc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jikemisma
 * @since 2021-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TSeckillOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 秒杀id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单id
     */
    private Long orderId;


}
