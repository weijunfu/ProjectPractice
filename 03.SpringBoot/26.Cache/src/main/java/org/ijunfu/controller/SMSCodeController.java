package org.ijunfu.controller;

import org.ijunfu.domain.SMSCode;
import org.ijunfu.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    SMSCodeService smsCodeService;

    @GetMapping
    public String getCode(String tel) {
        return smsCodeService.send(tel);
    }

    @PostMapping
    public Boolean checkCode(@RequestBody SMSCode smsCode) {
        return smsCodeService.checkCode(smsCode);
    }
}
