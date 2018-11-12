package com.zzq.config.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * created with IntelliJ IDEA.
 * author: fxbin
 * date: 2018/9/9
 * time: 12:15
 * description:
 */
public class Result {

    /**
     * 状态响应码
     */
    private int code;

    /**
     * 响应结果 成功/失败
     */
    private boolean success;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

}