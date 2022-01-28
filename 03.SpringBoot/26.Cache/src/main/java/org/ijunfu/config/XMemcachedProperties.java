package org.ijunfu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/28 21:31
 * @version 1.0.0
 *
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "xmemcached")
public class XMemcachedProperties {

    private String servers;
    private int poolSize;
    private long opTimeout;
}
