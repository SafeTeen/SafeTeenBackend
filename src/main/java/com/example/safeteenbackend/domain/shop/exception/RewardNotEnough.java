package com.example.safeteenbackend.domain.shop.exception;

import com.example.safeteenbackend.global.error.ErrorCode;
import com.example.safeteenbackend.global.error.exception.CustomException;

public class RewardNotEnough extends CustomException {
    public RewardNotEnough() {
        super(ErrorCode.REWRAD_NOT_ENOUGH);
    }
}
