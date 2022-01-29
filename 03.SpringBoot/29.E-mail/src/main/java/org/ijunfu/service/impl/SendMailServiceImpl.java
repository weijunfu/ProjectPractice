package org.ijunfu.service.impl;

import org.ijunfu.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/30 00:05
 * @version 1.0.0
 *
 */

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void send(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from+"(ijunfu)");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setSentDate(new Date());
        mailMessage.setText(content);

        mailSender.send(mailMessage);
    }
}
