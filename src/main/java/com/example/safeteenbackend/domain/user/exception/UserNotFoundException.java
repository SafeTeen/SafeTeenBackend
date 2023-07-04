package com.example.safeteenbackend.domain.user.exception;

import com.example.safeteenbackend.global.error.ErrorCode;
import com.example.safeteenbackend.global.error.exception.CustomException;

public class UserNotFoundException extends CustomException {
    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
