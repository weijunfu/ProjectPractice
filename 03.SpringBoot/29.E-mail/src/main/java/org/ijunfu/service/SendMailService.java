package org.ijunfu.service;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/30 00:04
 * @version 1.0.0
 *
 */

public interface SendMailService {

    void send(String to, String subject, String html);
}
