package com.ocbc.bookinocbcmicroapp.core.exception;

import com.ocbc.bookinocbcmicroapp.constant.Code;
import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpException{
    private static final long serialVersionUID = 3147792856922208240L;
    private int code;
    private int httpCode;

    public NotFoundException() {
        super(Code.NOT_FOUND.getDescription(), Code.NOT_FOUND.getCode());
        this.code = Code.NOT_FOUND.getCode();
        this.httpCode = HttpStatus.NOT_FOUND.value();
    }

    public NotFoundException(String message) {
        super(message);
        this.code = Code.NOT_FOUND.getCode();
        this.httpCode = HttpStatus.NOT_FOUND.value();
    }

    public NotFoundException(String message, int code) {
        super(message, code);
        this.code = Code.NOT_FOUND.getCode();
        this.httpCode = HttpStatus.NOT_FOUND.value();
        this.code = code;
    }

    public NotFoundException(int code) {
        super(Code.NOT_FOUND.getDescription(), code);
        this.code = Code.NOT_FOUND.getCode();
        this.httpCode = HttpStatus.NOT_FOUND.value();
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public int getHttpCode() {
        return this.httpCode;
    }
}
