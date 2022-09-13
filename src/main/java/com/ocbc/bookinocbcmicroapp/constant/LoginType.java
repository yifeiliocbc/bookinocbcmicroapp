package com.ocbc.bookinocbcmicroapp.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum LoginType {
    USER_WX(0,"微信登录"),
    USER_Email(1,"邮箱登录"),
    USER_Phone(2,"手机登录");

    private Integer value;
    private String description;

    LoginType(Integer value, String description){
        this.value = value;
        this.description = description;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @JsonCreator
    public static LoginType getLoginType(Integer code) {
        if (code == null) {
            return null;
        }
        LoginType[] values = LoginType.values();
        return Stream.of(values).filter(it -> it.getValue().equals(code)).findAny().orElse(null);
    }
}
