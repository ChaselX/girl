package com.chasel.girl.exception;

import com.chasel.girl.enums.ResultEnum;

/**
 * @author XieLongzhen
 * @date 2018/7/16 15:15
 */
public class StatusCodeRuntimeException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public StatusCodeRuntimeException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public StatusCodeRuntimeException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
