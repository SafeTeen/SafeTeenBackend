package com.example.safeteenbackend.domain.board.exception;

import com.example.safeteenbackend.global.error.ErrorCode;
import com.example.safeteenbackend.global.error.exception.CustomException;

public class BoardNotFound extends CustomException {
    public BoardNotFound() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
