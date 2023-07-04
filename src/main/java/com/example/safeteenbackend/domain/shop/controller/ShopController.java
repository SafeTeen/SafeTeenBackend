package com.example.safeteenbackend.domain.shop.controller;

import com.example.safeteenbackend.domain.shop.controller.dto.request.ShopRequest;
import com.example.safeteenbackend.domain.shop.controller.dto.response.ShopResponse;
import com.example.safeteenbackend.domain.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/shop")
    public void save(@RequestBody ShopRequest request){
        shopService.save(request);
    }

    @GetMapping("/shop")
    public ShopResponse list() {
        return shopService.list();
    }

    @PostMapping("/shop/{shop_id}")
    public void buy(@PathVariable int shop_id){
        shopService.buy(shop_id);
    }
}
