package com.yazi.minicart.exceptions;

public class ApiError {
    private int statusCode; // HTTP 状态码
    private String errorCode; // 自定义错误代码
    private String message; // 错误消息
    private String path; // 请求路径
    private long timestamp; // 时间戳

    public ApiError(int statusCode, String errorCode, String message, String path) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
        this.path = path;
        this.timestamp = System.currentTimeMillis();
    }
}
