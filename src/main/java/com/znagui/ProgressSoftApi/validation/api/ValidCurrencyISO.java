package com.znagui.ProgressSoftApi.validation.api;

import com.znagui.ProgressSoftApi.validation.CurrencyISOValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = CurrencyISOValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCurrencyISO {
    boolean allowNull() default false;
    String message() default "Invalid currency ISO code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
