package org.ijunfu.shopping.utils;

import org.junit.jupiter.api.Test;

/**
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @version 1.0.0
 * @Title <Title>
 * @Description <TODO>
 * @date 2022/01/07 21:51
 */
class MD5UtilTest {

    @Test
    public void test() {
        String data = "123456";
        String md5 = MD5Util.md5WithFixSalt(data);
        System.out.println(md5);

        String salt = "Wei.126893$jdksweskdjksjdksjdksdweiowe";

        md5 = MD5Util.md5WithRandomSalt(md5, salt);
        System.out.println(md5);

        System.out.println(MD5Util.encodedMD5(data, salt));
    }
}