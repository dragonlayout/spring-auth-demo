package org.example.spingauth.authorization;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(0, "操作成功"),
    UNAUTHORIZED(1001 ,"未登录"),
    FORBIDDEN(1002, "没有相关权限"),
    FAILED(1004, "接口异常"),
    ERROR(5000, "未知错误")
    ;

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
