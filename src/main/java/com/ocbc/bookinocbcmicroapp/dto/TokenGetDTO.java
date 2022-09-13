package com.ocbc.bookinocbcmicroapp.dto;

import com.ocbc.bookinocbcmicroapp.constant.LoginType;
import com.ocbc.bookinocbcmicroapp.dto.validators.LoginCategory;
import com.ocbc.bookinocbcmicroapp.dto.validators.TokenPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenGetDTO {

    @NotBlank(message = "account不允许为空")
    private String account;

    @TokenPassword(max = 30, message = "{token.password}")
    private String password;

    @LoginCategory
    private LoginType type;
}
