package com.yazi.minicart.exceptions;

import lombok.Getter;

@Getter
public class InvalidRequestException extends RuntimeException {
    private final String errorCode;
    public InvalidRequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
