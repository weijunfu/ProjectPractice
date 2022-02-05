package org.ijunfu.exception.service;

import org.ijunfu.exception.service.ServiceException;

/**
 *
 * @Title          用户名或密码错误
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/05 14:24
 * @version 1.0.0
 *
 */

public class UsernameOrPasswordException extends ServiceException {

    public UsernameOrPasswordException(String message) {
        super(message);
    }

    public UsernameOrPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameOrPasswordException(Throwable cause) {
        super(cause);
    }
}
