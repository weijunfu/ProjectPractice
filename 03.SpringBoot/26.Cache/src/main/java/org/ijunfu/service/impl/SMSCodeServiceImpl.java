package org.ijunfu.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.ijunfu.config.CacheConfig;
import org.ijunfu.domain.SMSCode;
import org.ijunfu.service.SMSCodeService;
import org.ijunfu.utils.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/27 01:08
 * @version 1.0.0
 *
 */

@Slf4j
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private SMSUtil smsUtil;

    @Override
    @CachePut(cacheNames = {"smsCode"}, key = "#tel")
    public String send(String tel) {
        return smsUtil.generator(tel);
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String tel = smsCode.getTel();
        String code = smsCode.getCode();

        log.info("tel={} code={}", tel, code);

        String codeCache = smsUtil.getSMSCodeFromCache(tel);

        log.info("tel={} code={} cache={} ret:{}", tel, code, codeCache, code.equals(codeCache));

        return code.equals(codeCache);
    }

}
