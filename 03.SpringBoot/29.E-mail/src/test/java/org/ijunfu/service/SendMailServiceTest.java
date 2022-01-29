package org.ijunfu.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

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

    @Test
    void sendHtml() {
        sendMailService.sendHTML("3300308280@qq.com", "测试 HTML" + System.currentTimeMillis(), "测试<a href='#'>邮件</a>内容<img src='https://inews.gtimg.com/newsapp_bt/0/14471018263/1000'/>");
    }

    @Test
    void sendAttach() {
        File[] files = new File[2];
        files[0] = new File("D:\\时间的玫瑰（全新升级版）.pdf");
        files[1] = new File("D:\\a.png");
        sendMailService.sendAttach("3300308280@qq.com", "测试 HTML & Attach" + System.currentTimeMillis(), "测试<a href='#'>邮件</a>内容<img src='https://inews.gtimg.com/newsapp_bt/0/14471018263/1000'/>", files);
    }
}