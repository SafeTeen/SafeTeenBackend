package com.example.safeteenbackend.domain.shop.service;

import com.example.safeteenbackend.domain.shop.controller.dto.request.ShopRequest;
import com.example.safeteenbackend.domain.shop.controller.dto.response.ShopResponse;
import com.example.safeteenbackend.domain.shop.entity.Shop;
import com.example.safeteenbackend.domain.shop.exception.RewardNotEnough;
import com.example.safeteenbackend.domain.shop.exception.ShopNotFound;
import com.example.safeteenbackend.domain.shop.repository.ShopRepository;
import com.example.safeteenbackend.domain.user.entity.User;
import com.example.safeteenbackend.domain.user.exception.UserNotFoundException;
import com.example.safeteenbackend.domain.user.repository.UserRepository;
import com.example.safeteenbackend.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;

    @Transactional
    public void save(ShopRequest request) {
        Shop shop = Shop.builder()
                .product_name(request.getProduct_name())
                .product_img(request.getProduct_img())
                .price(request.getPrice())
                .build();
        shopRepository.save(shop);
    }

    @Transactional
    public ShopResponse list() {
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        List<Shop> shopList = shopRepository.findAll();

        return ShopResponse.builder()
                .shopList(shopList)
                .userReward(user.getReward())
                .build();
    }

    @Transactional
    public void buy(int shop_id) {
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Shop shop = shopRepository.findById(shop_id).orElseThrow(ShopNotFound::new);

        user.getShopList().add(shop);
        if (user.getReward() - shop.getPrice() < 0)
            throw new RewardNotEnough();
        user.editReward(user.getReward() - shop.getPrice());
        userRepository.save(user);
    }
}
