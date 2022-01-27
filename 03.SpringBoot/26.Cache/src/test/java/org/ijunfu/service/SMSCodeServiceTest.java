package org.ijunfu.service;

import org.ijunfu.config.CacheConfig;
import org.ijunfu.domain.SMSCode;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/27 13:59
 * @version 1.0.0
 *
 */
@SpringBootTest
class SMSCodeServiceTest {

    Logger log = LoggerFactory.getLogger(SMSCodeServiceTest.class);

    @Autowired
    SMSCodeService smsCodeService;

    @Autowired
    CacheConfig cacheConfig;

    @Test
    void sms() {
        String tel = "18888888888";
        SMSCode sms = new SMSCode();
        sms.setTel(tel);

        String code = smsCodeService.send(sms.getTel());
        log.info("tel={}\t\tcode = {}", tel, code);
        sms.setCode(code);

        String codeFromCache = cacheConfig.getSMSCodeFromCache(tel);
        log.info("cache code: {}", codeFromCache);

        boolean ret = smsCodeService.checkCode(sms);

        assertEquals(true, ret);
    }
}