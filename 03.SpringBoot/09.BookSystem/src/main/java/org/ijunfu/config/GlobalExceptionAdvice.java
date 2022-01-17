package org.ijunfu.config;

import org.ijunfu.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @Title          全局异常处理
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/17 21:27
 * @version 1.0.0
 *
 */

@RestControllerAdvice
public class GlobalExceptionAdvice {

    Logger log = LoggerFactory.getLogger(GlobalExceptionAdvice.class);;


    @ExceptionHandler(IOException.class)
    public Response doException(IOException ex) {

        // 记录日志
        log.error("{}: {}", "操作 IO 失败", ex.getMessage());

        // 通知运维

        // 通知开发
        ex.printStackTrace();

        return Response.error("操作失败");
    }

    @ExceptionHandler(SQLException.class)
    public Response doException(SQLException ex) {

        // 记录日志
        log.error("{}: {}", "操作数据库失败", ex.getMessage());

        // 通知运维

        // 通知开发
        ex.printStackTrace();

        return Response.error("操作失败");
    }

    @ExceptionHandler(Exception.class)
    public Response doException(Exception ex) {

        // 记录日志
        log.error("{}: {}", "遇到未知错误", ex.getMessage());

        // 通知运维

        // 通知开发
        ex.printStackTrace();

        return Response.error("操作失败");
    }
}
