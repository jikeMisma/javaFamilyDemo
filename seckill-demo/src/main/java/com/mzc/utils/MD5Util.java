package com.mzc.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 *
 * md5工具类
 *
 * @author MaZhiCheng
 * @date 2021/6/24 - 16:51
 * @motto 腹有诗书气自华
 * @博客地址 https://blog.csdn.net/mzc_love
 */

@Component
public class MD5Util {

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    public static  String inputPassToFromPass(String inputpas){
        String str =""+ salt.charAt(0)+salt.charAt(2)+inputpas+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    public static  String FromPassToDbPass(String frompas,String salt){
        String str =""+ salt.charAt(0)+salt.charAt(2)+frompas+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    public static String inputPasToDbPas(String inputpass,String salt){
        String frompass = inputPassToFromPass(inputpass);
        String dbpass = FromPassToDbPass(frompass, salt);
        return dbpass;
    }

    public static void main(String[] args) {
        //d3b1294a61a07da9b49b6e22b2cbd7f9
        System.out.println(inputPassToFromPass("123456"));
        System.out.println(FromPassToDbPass("d3b1294a61a07da9b49b6e22b2cbd7f9", "1a2b3c4d"));
        String pass = inputPasToDbPas("123456", "1a2b3c4d");
        System.out.println(pass);
    }
}
