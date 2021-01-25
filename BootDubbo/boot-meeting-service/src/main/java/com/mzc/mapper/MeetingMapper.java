package com.mzc.mapper;

import com.mzc.pojo.MeetingPub;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author MaZhiCheng
 * @date 2021/1/24 - 14:04
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Repository
public interface MeetingMapper {

    MeetingPub findByPcode(String pcode);
}
