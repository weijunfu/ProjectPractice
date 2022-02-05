package org.ijunfu.controller;

import lombok.extern.slf4j.Slf4j;
import org.ijunfu.exception.service.ServiceException;
import org.ijunfu.exception.service.UserNotFoundException;
import org.ijunfu.exception.service.UsernameOrPasswordException;
import org.ijunfu.utils.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @Title          全局异常处理类
 * @Description    统一处理异常
 *
 * @author weijunfu<ijunfu@qq.com>
 * @date 2022/02/05 17:01
 * @version 1.0.0
 *
 */

@Slf4j
@ControllerAdvice
public class MyControllerAdvice {


    @ResponseBody
    @ExceptionHandler(value = UserNotFoundException.class)
    public Response<String> handler(UserNotFoundException e) {
        log.error("{}", e.getMessage());
        e.printStackTrace();
        return Response.error("用户不存在");
    }

    @ResponseBody
    @ExceptionHandler(value = UsernameOrPasswordException.class)
    public Response<String> handler(UsernameOrPasswordException e) {
        log.error("{}", e.getMessage());
        e.printStackTrace();
        return Response.error("用户名或密码错误");
    }

    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public Response<String> handler(ServiceException e) {
        log.error("{}", e.getMessage());
        e.printStackTrace();
        return Response.error("业务处理失败");
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Response<String> handler(Exception e) {
        log.error("{}", e.getMessage());
        e.printStackTrace();
        return Response.error("未知错误");
    }
}
