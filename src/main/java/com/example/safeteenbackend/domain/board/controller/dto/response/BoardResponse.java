package com.example.safeteenbackend.domain.board.controller.dto.response;

import com.example.safeteenbackend.domain.comment.controller.dto.response.CommentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class BoardResponse {
    private int id;
    private String title;
    private String ask;
    private LocalDateTime dateTime;
    private List<CommentResponse> commentList;
}
