package org.ijunfu.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.MD5;
import org.springframework.util.StringUtils;

import java.util.Locale;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ qq.com>
 * @date 2022/02/05 16:09
 * @version 1.0.0
 *
 */

public class StringHelper {

    public final static String CHARS = "abcdefghijklmnopqrstuvwxyz";
    public final static String NUMBERS = "0123456789";


    public static String random(int len) {
        StringBuilder sb = new StringBuilder();
        sb.append(CHARS)
          .append(NUMBERS)
          .append(CHARS.toUpperCase(Locale.ROOT));
        return RandomUtil.randomString(sb.toString(), len);
    }

    public static String encode(String password, String salt) {
        MD5 md5 = new MD5();

        StringBuilder sb = new StringBuilder();
        sb.append(salt.substring(17, 29))
          .append(17)
          .append(password)
          .append(29)
          .append(salt.substring(12, 17))
        ;

        String ret = md5.digestHex(sb.toString());

        StringBuilder buffer = new StringBuilder();
        buffer.append(ret).reverse().append(ret);

        return md5.digestHex(buffer.toString());
    }
}
