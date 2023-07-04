package com.example.safeteenbackend.domain.rating.repository;

import com.example.safeteenbackend.domain.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
