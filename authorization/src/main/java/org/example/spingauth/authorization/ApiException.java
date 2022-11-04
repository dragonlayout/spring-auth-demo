package org.example.spingauth.authorization;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = -521185264621511303L;

    private final String message;
    private final ResultCode resultCode;

    public ApiException() {
        this(ResultCode.FAILED);
    }

    public ApiException(String msg) {
        this(ResultCode.FAILED, msg);
    }

    public ApiException(ResultCode resultCode) {
        this(resultCode, resultCode.getMessage());
    }

    public ApiException(ResultCode resultCode, String msg) {
        super(msg);
        this.resultCode = resultCode;
        this.message =  msg;
    }
}
