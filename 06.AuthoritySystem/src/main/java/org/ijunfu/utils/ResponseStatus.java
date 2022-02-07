package org.ijunfu.utils;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/05 12:55
 * @version 1.0.0
 *
 */

public enum ResponseStatus {
    SUCCESS(0),       // 成功
    FAIL(-1),          // 失败
    UNAUTHORIZED(401),  // 未认证/认证失败
    NOT_FOUND(404),     // 接口（资源）不存在
    SERVER_ERROR(500)   // 服务器错误

    ,USER_NOT_FOUND(100001)             // 账户不存在
    ,USERNAME_OR_PASSWORD_ERROR(100002) // 用户名或密码错误
    ;

    private Integer code;

    ResponseStatus(Integer code) {
        this.code = code;
    }

    public Integer code(){
        return code;
    }
}
