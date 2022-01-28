package org.ijunfu.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/28 20:36
 * @version 1.0.0
 *
 */

@Configuration
public class XMemcachedConfig {

    @Autowired
    private XMemcachedProperties xMemcachedProperties;

    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {

        MemcachedClientBuilder builder = new XMemcachedClientBuilder(xMemcachedProperties.getServers());
        builder.setConnectionPoolSize(xMemcachedProperties.getPoolSize());
        builder.setOpTimeout(xMemcachedProperties.getOpTimeout());

        MemcachedClient client = builder.build();
        return client;
    }
}
