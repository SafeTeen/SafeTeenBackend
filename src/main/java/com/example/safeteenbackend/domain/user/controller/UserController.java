package com.example.safeteenbackend.domain.user.controller;

import com.example.safeteenbackend.domain.user.controller.dto.request.EditRequest;
import com.example.safeteenbackend.domain.user.controller.dto.response.UserResponse;
import com.example.safeteenbackend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/mypage")
    public UserResponse getUser() {
        return userService.getUser();
    }

    @PatchMapping("/mypage")
    public void editProfile(@RequestBody EditRequest request) {
        userService.editProfile(request);
    }

    @PatchMapping("/reward/{reward}")
    public void addReward(@PathVariable int reward) {
        userService.addReward(reward);
    }
}
