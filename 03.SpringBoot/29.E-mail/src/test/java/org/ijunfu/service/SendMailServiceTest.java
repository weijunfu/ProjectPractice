package org.ijunfu.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/30 00:06
 * @version 1.0.0
 *
 */
@SpringBootTest
class SendMailServiceTest {

    @Autowired
    private SendMailService sendMailService;


    @Test
    void sendText() {
        sendMailService.send("3300308280@qq.com", "测试" + System.currentTimeMillis(), "测试邮件内容");
    }
}