package com.amio.cts.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

/**
 * 统一响应结果封装
 *
 * @author : zhenfeng.liu
 * @date : 2018/9/4 17:24
 */
public class Response<T> implements Serializable {
    //  @JsonInclude(JsonInclude.Include.NON_NULL)  如果要排除Null的则注释在类上面

    private static final long serialVersionUID = 1L;
    /**
     * 请求成功返回码为：0000
     */
    private static final String SUCCESS_CODE = "0000";
    /**
     * 操作状态码
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 操作时间
     */
    private LocalDateTime actionTime;

    public Response() {
        this.code = SUCCESS_CODE;
        this.message = "请求成功";
        this.actionTime = LocalDateTime.now();
    }

    public Response(String code, String message, LocalDateTime actionTime) {
        this.code = code;
        this.message = message;
        this.actionTime = actionTime;
    }

    public Response(String code, String message, T data) {
        this();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(T data) {
        this();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }

    public void setActionTime(LocalDateTime actionTime) {
        this.actionTime = actionTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Response.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("message='" + message + "'")
                .add("data=" + data)
                .add("actionTime=" + actionTime)
                .toString();
    }
}
