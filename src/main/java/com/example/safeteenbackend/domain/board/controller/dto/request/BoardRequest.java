package com.example.safeteenbackend.domain.board.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardRequest {
    private String title;
    private String ask;
}
