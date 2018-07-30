package com.chasel.girl.enums;

/**
 * @author XieLongzhen
 * @date 2018/7/30 13:11
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(1,"成功"),
    PRIMARY_SCHOOL(100, "你可能还在上小学吧"),
    JUNIOR_HIGH_SCHOOL(101, "你可能还在上初中吧"),;


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
