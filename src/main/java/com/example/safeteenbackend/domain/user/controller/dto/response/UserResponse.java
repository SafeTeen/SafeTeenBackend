package com.example.safeteenbackend.domain.user.controller.dto.response;

import com.example.safeteenbackend.domain.board.entity.Board;
import com.example.safeteenbackend.domain.shop.entity.Shop;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserResponse {
    private String nickname;
    private int reward;
    private String profile_img;
    private List<Board> boardList;
    private List<Shop> shopList;
}
