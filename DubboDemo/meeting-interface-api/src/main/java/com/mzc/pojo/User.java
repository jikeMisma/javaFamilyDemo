package com.mzc.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MaZhiCheng
 * @date 2021/1/22 - 15:48
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Data
public class User implements Serializable {

    private String id;
    private String username;
    private String telphone;
}
