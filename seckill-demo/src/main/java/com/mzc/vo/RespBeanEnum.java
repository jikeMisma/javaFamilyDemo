package com.mzc.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 公共返回对象枚举
 * @author MaZhiCheng
 * @date 2021/6/24 - 22:01
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Getter
@ToString
@AllArgsConstructor
public enum  RespBeanEnum {

    //通用
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务异常"),

    //登录模块5002XX
    LOGIN_ERROR(500210,"用户名或密码错误"),
    MOBILE_ERROR(500211,"手机号码不正确"),
    BIND_ERROR(500212,"参数校验异常"),
    //秒杀模块5005XX
    EMPTY_SOCKET(500500,"库存不足"),
    REPEATE_ERROR(500501,"该商品没人限购一件")
    ;
    private final Integer code;

    private final String message;

}
