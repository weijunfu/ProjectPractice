package org.ijunfu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/23 21:38
 * @version 1.0.0
 *
 */

@SpringBootTest
public class StringRedisTemplateTest {

    @Autowired
    StringRedisTemplate redis;

    @Test
    void set() {
        ValueOperations<String, String> ops = redis.opsForValue();

        ops.set("age", "18");
    }

    @Test
    void get(){
        ValueOperations<String, String> ops = redis.opsForValue();
        String age = ops.get("age");
        System.out.println(age);

        Assertions.assertEquals("18", age);
    }
}
