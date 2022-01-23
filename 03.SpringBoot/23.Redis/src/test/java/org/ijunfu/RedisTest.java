package org.ijunfu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/23 20:36
 * @version 1.0.0
 *
 */

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    // 字符串
    @Test
    void setWithString() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("author", "ijunfu");
    }

    @Test
    void getWithString() {
        ValueOperations ops = redisTemplate.opsForValue();
        Object author = ops.get("author");
        System.out.println(author);
        Assertions.assertEquals("ijunfu", author.toString());
    }

    // Hash
    @Test
    void setWithHash(){
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("user", "name", "ijunfu");
    }

    @Test
    void getWithHash(){
        HashOperations ops = redisTemplate.opsForHash();
        Object name = ops.get("user", "name");
        System.out.println(name);
        Assertions.assertEquals("ijunfu", name.toString());
    }
}
