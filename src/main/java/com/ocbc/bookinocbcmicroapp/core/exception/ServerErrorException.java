package com.ocbc.bookinocbcmicroapp.core.exception;

public class ServerErrorException extends HttpException {
    public ServerErrorException(int code) {
        this.code = code;
        this.httpCode = 500;
    }
}
