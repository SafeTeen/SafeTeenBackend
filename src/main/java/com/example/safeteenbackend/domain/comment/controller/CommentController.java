package com.example.safeteenbackend.domain.comment.controller;

import com.example.safeteenbackend.domain.comment.entity.CommentEntity;
import com.example.safeteenbackend.domain.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService cS;

    // 답변 작성
    @PostMapping("/writedo")
    @ResponseBody
    public CommentEntity writeComment(@RequestBody CommentEntity comment) {
        cS.write(comment);
        return comment;
    }

    // 글 삭제
    @DeleteMapping("/delete/{id}")
    public String deleteComment(@PathVariable Integer id) {
        cS.deleteComment(id);
        return "삭제";
    }
}
