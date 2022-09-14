package com.ocbc.bookinocbcmicroapp.core.exception;

public class ParameterException extends HttpException {
    public ParameterException(int code) {
        this.code = code;
        this.httpCode = 400;
    }
}
