package com.example.safeteenbackend.domain.user.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignupRequest {
    private String nickname;
    private String email;
    private String password;
}
