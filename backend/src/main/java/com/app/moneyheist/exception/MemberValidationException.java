package com.app.moneyheist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MemberValidationException extends RuntimeException {
    public MemberValidationException(String message) {
        super(message);
    }
}
