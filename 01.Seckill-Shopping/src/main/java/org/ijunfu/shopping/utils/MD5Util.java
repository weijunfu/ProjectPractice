package org.ijunfu.shopping.utils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @version 1.0.0
 * @Title <Title>
 * @Description <TODO>
 * @date 2022/01/07 21:39
 */

public class MD5Util {

    /**
     * @Title       md5
     * @Description 使用MD5加密字符串
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/07 22:15
     * @version     1.0.0
     * @param 		data
     * @Return      java.lang.String
     */
    private static String md5(String data) {
        return DigestUtils.md5DigestAsHex(data.getBytes(StandardCharsets.UTF_8));
    }

    // 固定盐，用于客户端向服务器端发送加密数据
    private static  final String SALT = "Weizg&121729$ijunfu.";

    /**
     * @Title       md5WithFixSalt
     * @Description 使用固定盐加密字符串
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/07 22:16
     * @version     1.0.0
     * @param 		data    字符串
     * @Return      java.lang.String    使用md5加密后的字符串
     */
    public static String md5WithFixSalt(String data) {
        return md5WithRandomSalt(data, SALT);
    }

    /**
     * @Title       md5WithRandomSalt
     * @Description 使用自定义盐加密字符串
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/07 22:16
     * @version     1.0.0
     * @param 		data    字符串
     * @param 		salt    盐
     * @Return      java.lang.String    使用md5加密后的字符串
     */
    public static String md5WithRandomSalt(String data, String salt) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(salt.charAt(12))
                .append(salt.charAt(7))
                .append(data)
                .append(salt.charAt(9))
                .append(salt.charAt(13));
        return md5(buffer.toString());
    }

    /**
     * @Title       encodedMD5
     * @Description 使用自定义盐多次加密字符串
     * @author      weijunfu<ijunfu@163.com>
     * @date        2022/01/07 22:17
     * @version     1.0.0
     * @param 		data    字符串
     * @param 		salt    盐
     * @Return      java.lang.String    使用md5加密后的字符串
     */
    public static String encodedMD5(String data, String salt) {
        return md5WithRandomSalt(md5WithFixSalt(data), salt);
    }
}
