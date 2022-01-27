package org.ijunfu.config;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/27 01:56
 * @version 1.0.0
 *
 */

public class CacheConfig {

    @Bean(name = "smsKeyGenerator")
    public KeyGenerator smsKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(params[0].toString());

                return sb.toString();
            }
        };
    }

    @Cacheable(value = "smsCode")
    public String getSMSCodeFromCache(String tel) {
        return "";
    }
}
