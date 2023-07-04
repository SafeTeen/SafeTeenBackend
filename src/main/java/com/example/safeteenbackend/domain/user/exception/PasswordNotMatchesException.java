package com.example.safeteenbackend.domain.user.exception;

import com.example.safeteenbackend.global.error.ErrorCode;
import com.example.safeteenbackend.global.error.exception.CustomException;

public class PasswordNotMatchesException extends CustomException {
    public PasswordNotMatchesException(){
        super(ErrorCode.PASSWORD_NOT_MATCHES);
    }
}
