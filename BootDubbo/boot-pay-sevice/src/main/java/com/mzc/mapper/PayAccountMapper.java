package com.mzc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author MaZhiCheng
 * @date 2021/1/26 - 16:21
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Repository
@Mapper
public interface PayAccountMapper {

    String findAccountById(String uid);
}
