package org.ijunfu;

import org.ijunfu.config.MsgConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/21 23:15
 * @version 1.0.0
 *
 */

@SpringBootTest
@Import(MsgConfig.class)
public class MsgConfigTest {

    @Autowired
    private String msg;

    @Test
    public void testMsg() {
        Assertions.assertEquals("test msg", msg);
    }

}
