package com.example.safeteenbackend.domain.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EditRequest {
    private String nickname;
    private String profile_img;
}
