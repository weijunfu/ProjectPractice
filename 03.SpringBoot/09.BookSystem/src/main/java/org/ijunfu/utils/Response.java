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

public class Response {

    private Integer status;

    private String msg;

    private Object data;

    public Response() {}

    public Response(Integer status) {
        this.status = status;
    }

    public Response(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Response(Integer status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Response(String msg, Object data) {
       this.msg = msg;
       this.data = data;

    }

    public Response(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static Response ok(){
        return new Response(Status.OK);
    }

    public static Response ok(Object data) {
        return new Response(Status.OK, data);
    }

    public static Response ok(Integer status, String msg, Object data) {
        return new Response(status, msg, data);
    }

    public static Response error(){
        return new Response(Status.ERROR);
    }

    public static Response error(Object data) {
        return new Response(Status.OK, data);
    }

    public static Response error(Integer status, String msg, Object data) {
        return new Response(status, msg, data);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
