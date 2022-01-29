package org.ijunfu.service.impl;

import org.ijunfu.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
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

    @Override
    public void sendHTML(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message);

        try {
            messageHelper.setFrom(from+"(ijunfu)");
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setSentDate(new Date());
            messageHelper.setText(content, true);

            mailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sendAttach(String to, String subject, String content, File[] files){

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setFrom(from+"(ijunfu)");
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setSentDate(new Date());
            messageHelper.setText(content, true);

            // 附件
            if(null != files && files.length > 0) {

                for(File file : files) {
                    messageHelper.addAttachment(file.getName(), file);
                }

            }

            mailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
