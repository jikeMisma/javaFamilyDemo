package com.mzc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MaZhiCheng
 * @date 2021/1/23 - 15:10
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */
@Data
public class User implements Serializable {

    private String id;

    private String name;

    private String email;

    private String city;

    private String telphone;

    private Date createdate;

}
