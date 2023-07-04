package com.example.safeteenbackend.domain.shop.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShopRequest {
    private String product_name;
    private String product_img;
    private int price;
}
