package com.ocbc.bookinocbcmicroapp.dto.validators;

import com.ocbc.bookinocbcmicroapp.constant.LoginType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginCategoryValidator implements ConstraintValidator<LoginCategory, Enum<LoginType>> {

    @Override
    public boolean isValid(Enum<LoginType> value, ConstraintValidatorContext constraintValidatorContext) {
        if (value instanceof LoginType) {
            return true;
        }
        return false;
    }
}
