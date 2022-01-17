package org.ijunfu.utils;

/**
 *
 * @Title          统一响应结果类
 * @Description    <TODO>
 *
 * @author weijunfu<ijunfu @ 1 6 3 . com>
 * @date 2022/01/17 13:45
 * @version 1.0.0
 *
 */

public class Response<T> {

    private Integer status;

    private String msg;

    private T data;

    public Response() {}

    public Response(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Response(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static Response<?> ok(){
        return new Response<>(Status.OK, "成功");
    }

    public static Response<?> ok(String msg){
        return new Response<>(Status.OK, msg);
    }

    public static <T> Response<T> ok(String msg, T data){
        return new Response<T>(Status.OK, msg, data);
    }

    public static Response<?> error(){
        return new Response<>(Status.ERROR, "成功");
    }

    public static Response<?> error(String msg){
        return new Response<>(Status.ERROR, msg);
    }

    public static <T> Response<T> error(String msg, T data){
        return new Response<T>(Status.ERROR, msg, data);
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
