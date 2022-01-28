package org.ijunfu.controller;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.ijunfu.domain.SMSCode;
import org.ijunfu.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeoutException;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/27 01:09
 * @version 1.0.0
 *
 */

@Slf4j
@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    SMSCodeService smsCodeService;

    @Autowired
    MemcachedClient memcachedClient;

    @GetMapping
    public String getCode(String tel) {
        String code = smsCodeService.send(tel);

        try {
            memcachedClient.set(tel, 10, code);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{}", e.getMessage());
        }

        return code;
    }

    @PostMapping
    public Boolean checkCode(@RequestBody SMSCode smsCode) {

        try {
            String code = memcachedClient.get(smsCode.getTel()).toString();

            return smsCode.getCode().equals(code);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{}", e.getMessage());
        }

        return false;
        //        return smsCodeService.checkCode(smsCode);
    }
}
