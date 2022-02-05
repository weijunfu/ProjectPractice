package org.ijunfu.utils;

import lombok.Data;

/**
 *
 * @Title          <Title>
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/02/05 12:47
 * @version 1.0.0
 *
 */

@Data
public class Response<T> {

    private Integer status;
    private String  msg;
    private T data;

    public static Response ok() {
        return ok(null);
    }

    public static <T> Response ok(T data) {
        Response response = new Response();
        response.setStatus(ResponseStatus.SUCCESS.code());
        response.setMsg("成功");
        response.setData(data);
        return response;
    }

    public static Response error(String msg) {
        Response response = new Response();
        response.setStatus(ResponseStatus.FAIL.code());
        response.setMsg(msg);
        return response;
    }
}
