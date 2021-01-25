package com.mzc.mapper;

import com.mzc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author MaZhiCheng
 * @date 2021/1/23 - 15:13
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Repository
public interface UserMapper {

    User findById(String id);
}
