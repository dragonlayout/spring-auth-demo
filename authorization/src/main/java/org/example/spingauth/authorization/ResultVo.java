package org.example.spingauth.authorization;

import lombok.Getter;

@Getter
public class ResultVo<T> {
    /**
     * 状态码, 默认1000是成功
     */
    private final int code;
    /**
     * 响应信息, 来说明响应情况
     */
    private final String msg;
    /**
     * 响应的具体数据
     */
    private final T data;

    public ResultVo(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVo(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
        this.data = data;
    }
}
