package com.znagui.ProgressSoftApi.exception;

public class CurrencyCodesIdenticalException extends RuntimeException {
    public CurrencyCodesIdenticalException() {
        super("currency codes are identical");
    }
}
