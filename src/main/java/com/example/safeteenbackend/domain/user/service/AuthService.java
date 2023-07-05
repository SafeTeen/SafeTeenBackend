package com.example.safeteenbackend.domain.user.service;

import com.example.safeteenbackend.domain.user.controller.dto.request.LoginRequest;
import com.example.safeteenbackend.domain.user.controller.dto.request.SignupRequest;
import com.example.safeteenbackend.domain.user.controller.dto.response.TokenResponse;
import com.example.safeteenbackend.domain.user.entity.User;
import com.example.safeteenbackend.domain.user.exception.AlreadyExistException;
import com.example.safeteenbackend.domain.user.exception.PasswordNotMatchesException;
import com.example.safeteenbackend.domain.user.exception.UserNotFoundException;
import com.example.safeteenbackend.domain.user.repository.UserRepository;
import com.example.safeteenbackend.global.jwt.TokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(SignupRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent())
            throw new AlreadyExistException();

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .build();
        userRepository.save(user);
    }

    @Transactional
    public TokenResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(UserNotFoundException::new);
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new PasswordNotMatchesException();

        String accessToken = tokenProvider.createAccessToken(request.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
