package com.ocbc.bookinocbcmicroapp.vo;

import com.ocbc.bookinocbcmicroapp.constant.Code;
import com.ocbc.bookinocbcmicroapp.util.ResponseUtil;
import org.springframework.http.HttpStatus;

public class UpdatedVO<T> extends UnifyResponseVO {

    public UpdatedVO() {
        super(Code.UPDATED.getCode());
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

    public UpdatedVO(int code) {
        super(code);
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

    public UpdatedVO(T message) {
        super(message);
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

    public UpdatedVO(int code, T message) {
        super(code, message);
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

}
