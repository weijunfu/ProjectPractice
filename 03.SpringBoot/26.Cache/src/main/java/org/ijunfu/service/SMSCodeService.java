package org.ijunfu.service;

import org.ijunfu.domain.SMSCode;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/27 01:07
 * @version 1.0.0
 *
 */

public interface SMSCodeService {

    String send(String tel);

    boolean checkCode(SMSCode smsCode);
}
