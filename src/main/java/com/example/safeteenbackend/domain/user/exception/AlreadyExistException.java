package com.example.safeteenbackend.domain.user.exception;

import com.example.safeteenbackend.global.error.ErrorCode;
import com.example.safeteenbackend.global.error.exception.CustomException;

public class AlreadyExistException extends CustomException {
    public AlreadyExistException(){
        super(ErrorCode.ALREADY_EXIST);
    }
}
