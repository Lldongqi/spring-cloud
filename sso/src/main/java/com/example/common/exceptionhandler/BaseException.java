package com.example.common.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BaseException extends RuntimeException {
    private Integer code;//状态码
    private Object data;//异常信息
    public BaseException(int errorCode, String message) {
        super(message);
        this.code = errorCode;
    }
    public BaseException(int errorCode, String message, Object data) {
        super(message);
        this.code = errorCode;
        this.data = data;
    }
}
