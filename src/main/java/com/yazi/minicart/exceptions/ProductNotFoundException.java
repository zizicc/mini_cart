package com.yazi.minicart.exceptions;

public class ProductNotFoundException extends RuntimeException {
    private final String errorCode;
    public ProductNotFoundException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
