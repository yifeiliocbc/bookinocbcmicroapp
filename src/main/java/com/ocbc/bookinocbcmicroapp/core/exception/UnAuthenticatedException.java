package com.ocbc.bookinocbcmicroapp.core.exception;

public class UnAuthenticatedException extends HttpException {
    public UnAuthenticatedException(int code) {
        this.code = code;
        this.httpCode = 401;
    }
}
