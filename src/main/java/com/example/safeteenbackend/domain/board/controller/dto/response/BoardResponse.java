package com.example.safeteenbackend.domain.board.controller.dto.response;

import com.example.safeteenbackend.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class BoardResponse {
    private int id;
    private String title;
    private String ask;
    private LocalDateTime dateTime;
    private User user;
}
