package org.ijunfu.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/21 23:14
 * @version 1.0.0
 *
 */

@Configuration
public class MsgConfig {

    @Bean
    public String msg() {
        return "test msg";
    }
}
