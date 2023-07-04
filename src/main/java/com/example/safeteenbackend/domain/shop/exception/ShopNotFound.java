package com.example.safeteenbackend.domain.shop.exception;

import com.example.safeteenbackend.global.error.ErrorCode;
import com.example.safeteenbackend.global.error.exception.CustomException;

public class ShopNotFound extends CustomException {
    public ShopNotFound() {
        super(ErrorCode.SHOP_NOT_FOUND);
    }
}
