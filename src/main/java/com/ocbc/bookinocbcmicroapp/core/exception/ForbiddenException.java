package com.ocbc.bookinocbcmicroapp.core.exception;


public class ForbiddenException extends HttpException {

    public ForbiddenException(int code) {
        this.code = code;
        this.httpCode = 403;
    }
}
