package com.ocbc.bookinocbcmicroapp.core.exception;

public interface BaseResponse {
    String getMessage();

    int getHttpCode();

    int getCode();
}
