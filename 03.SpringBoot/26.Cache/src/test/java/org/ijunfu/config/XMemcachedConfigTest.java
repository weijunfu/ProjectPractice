package org.ijunfu.config;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/28 21:20
 * @version 1.0.0
 *
 */
@Slf4j
@SpringBootTest
class XMemcachedConfigTest {

    @Autowired
    MemcachedClient memcachedClient;

    @Test
    void conn() {
        log.info("{}", memcachedClient);
    }
}