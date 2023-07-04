package com.example.safeteenbackend.domain.user.service;

import com.example.safeteenbackend.domain.user.controller.dto.request.EditRequest;
import com.example.safeteenbackend.domain.user.controller.dto.response.UserResponse;
import com.example.safeteenbackend.domain.user.entity.User;
import com.example.safeteenbackend.domain.user.exception.UserNotFoundException;
import com.example.safeteenbackend.domain.user.repository.UserRepository;
import com.example.safeteenbackend.global.util.SecurityUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse getUser() {
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        return UserResponse.builder()
                .nickname(user.getNickname())
                .reward(user.getReward())
                .profile_img(user.getProfile_img())
                .boardList(user.getBoardList())
                .shopList(user.getShopList())
                .build();
    }

    @Transactional
    public void editName(EditRequest request) {
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        user.editName(request.getNickname());
        userRepository.save(user);
    }
}
