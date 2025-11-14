package com.znagui.ProgressSoftApi.validation;

import com.znagui.ProgressSoftApi.validation.api.ValidCurrencyISO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Currency;
@Slf4j
public class CurrencyISOValidator implements ConstraintValidator<ValidCurrencyISO, String> {

    private boolean allowNull;

    @Override
    public void initialize(ValidCurrencyISO constraintAnnotation) {
        this.allowNull = constraintAnnotation.allowNull();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            log.debug("Currency validation: value is null (allowNull={})", allowNull);
            return allowNull;
        }
        String code = value.trim().toUpperCase();
        if (code.length() != 3) {
            log.warn("Invalid currency code length: {}", value);
            return false;
        }
        try {
            Currency.getInstance(code);
            log.debug("Valid currency ISO code: {}", code);
            return true;
        } catch (IllegalArgumentException e) {
            log.warn("Invalid ISO currency code provided: {}", code);
            return false;
        }
    }
}
