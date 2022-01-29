# 电子邮件

## 协议

### SMTP
`Simple Mail Transfer Protocol`简单邮件传输协议，用于发送电子邮件的传输协议。

### POP3
`Post Office Protocol - Version 3`用于接收电子邮件的标准协议。

### IMAP
`Internet Mail Access Protocol`互联网消息协议，是**POP3**的替代协议。

## 整合

### 1. 导入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

### 2. 配置邮箱
```yaml
spring:
  mail:
    host: smtp.sina.com
    username: 
    password: 
```

### 3. 发送邮件
```java
@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void send(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from+"(ijunfu)");   // 邮箱显示昵称：ijunfu
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setSentDate(new Date());
        mailMessage.setText(content);

        mailSender.send(mailMessage);
    }
}
```
