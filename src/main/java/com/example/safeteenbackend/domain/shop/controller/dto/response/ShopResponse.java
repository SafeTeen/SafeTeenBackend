package com.example.safeteenbackend.domain.shop.controller.dto.response;

import com.example.safeteenbackend.domain.shop.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ShopResponse {
    private List<Shop> shopList;
    private int userReward;
}
