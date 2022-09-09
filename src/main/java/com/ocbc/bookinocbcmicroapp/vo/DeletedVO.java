package com.ocbc.bookinocbcmicroapp.vo;

import com.ocbc.bookinocbcmicroapp.constant.Code;
import com.ocbc.bookinocbcmicroapp.util.ResponseUtil;
import org.springframework.http.HttpStatus;

public class DeletedVO<T> extends UnifyResponseVO {

    public DeletedVO() {
        super(Code.DELETED.getCode());
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

    public DeletedVO(int code) {
        super(code);
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

    public DeletedVO(T message) {
        super(message);
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

    public DeletedVO(int code, T message) {
        super(code, message);
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

}
