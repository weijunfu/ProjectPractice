package org.ijunfu.exception.service;

import org.ijunfu.exception.service.ServiceException;

/**
 *
 * @Title          用户不存在
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/05 14:25
 * @version 1.0.0
 *
 */

public class UserNotFoundException extends ServiceException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
