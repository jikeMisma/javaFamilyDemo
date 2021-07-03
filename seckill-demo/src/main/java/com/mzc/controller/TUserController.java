package com.mzc.controller;


import com.mzc.pojo.TUser;
import com.mzc.vo.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jikemisma
 * @since 2021-06-24
 */
@RestController
@RequestMapping("/user")
public class TUserController {


    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(TUser user){
        return RespBean.success(user);
    }

}

