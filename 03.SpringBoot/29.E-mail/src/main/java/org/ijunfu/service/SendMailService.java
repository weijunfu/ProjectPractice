package org.ijunfu.service;

import java.io.File;

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

    void sendHTML(String to, String subject, String content);

    void sendAttach(String to, String subject, String content, File[] files);
}
