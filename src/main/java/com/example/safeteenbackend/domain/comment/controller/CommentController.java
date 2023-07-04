package com.example.safeteenbackend.domain.comment.controller;

import com.example.safeteenbackend.domain.comment.controller.dto.request.CommentRequest;
import com.example.safeteenbackend.domain.comment.controller.dto.response.CommentResponse;
import com.example.safeteenbackend.domain.comment.entity.CommentEntity;
import com.example.safeteenbackend.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {


    private final CommentService cS;

    // 답변 작성
    @PostMapping("/comment")
    public CommentResponse writeComment(@RequestBody CommentRequest comment) {

        return cS.write(comment);
    }

    // 글 삭제
    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Integer id) {
        cS.deleteComment(id);
    }
}
