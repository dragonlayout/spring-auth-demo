package org.example.spingauth.authorization;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerHandler {

    @ExceptionHandler(ApiException.class)
    public ResultVo<String> apiExceptionHandler(ApiException e) {
        return new ResultVo<>(e.getResultCode(), e.getMessage());
    }
}
