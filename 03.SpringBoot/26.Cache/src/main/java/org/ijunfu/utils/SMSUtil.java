package org.ijunfu.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/27 01:14
 * @version 1.0.0
 *
 */

@Component
public class SMSUtil {

    final static String[] ZEROS = {"00000", "00000", "000", "00", "0", ""};

    public String generator(String tel) {
        int hash = tel.hashCode();
        int encryption = 19920121;

        int ret = hash ^ encryption;

        long millis = System.currentTimeMillis();
        ret ^= millis;

        ret = ret < 0 ? -ret : ret;

        String str = String.valueOf(ret % 1000000);
        int len = str.length();

        return ZEROS[len-1] + str;
    }

    @Cacheable(cacheNames = {"smsCode"}, key = "#tel")
    public String getSMSCodeFromCache(String tel) {
        return null;
    }
}
