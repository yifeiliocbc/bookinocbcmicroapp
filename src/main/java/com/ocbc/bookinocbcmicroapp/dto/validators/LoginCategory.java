package com.ocbc.bookinocbcmicroapp.dto.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = {LoginCategoryValidator.class})
public @interface LoginCategory {
    int value() default 2;

    String message() default "Login type does not meet the requirements";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
