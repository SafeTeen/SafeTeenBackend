package com.example.safeteenbackend.domain.shop.repository;

import com.example.safeteenbackend.domain.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
