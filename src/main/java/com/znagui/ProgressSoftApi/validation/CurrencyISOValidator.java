package com.znagui.ProgressSoftApi.validation;

import com.znagui.ProgressSoftApi.validation.api.ValidCurrencyISO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Currency;

public class CurrencyISOValidator implements ConstraintValidator<ValidCurrencyISO, String> {

    private boolean allowNull;

    @Override
    public void initialize(ValidCurrencyISO constraintAnnotation) {
        this.allowNull = constraintAnnotation.allowNull();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return allowNull;
        }
        String code = value.trim().toUpperCase();
        if (code.length() != 3) {
            return false;
        }
        try {
            Currency.getInstance(code);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
