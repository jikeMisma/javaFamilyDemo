package com.mzc.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author MaZhiCheng
 * @date 2021/7/11 - 22:23
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {

    private String name;

    private int age;

    private String desc;

    private String tags;
}
