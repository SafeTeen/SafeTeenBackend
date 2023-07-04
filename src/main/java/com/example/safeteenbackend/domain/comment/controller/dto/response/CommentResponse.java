package com.example.safeteenbackend.domain.comment.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class CommentResponse {
    private String content;
    private LocalDateTime createCommentTime;
}
