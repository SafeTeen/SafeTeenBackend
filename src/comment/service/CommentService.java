package com.example.safeteenbackend.domain.comment.service;

import com.example.safeteenbackend.domain.comment.entity.CommentEntity;
import com.example.safeteenbackend.domain.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository cR;

    //답변 작성
    public void write(CommentEntity comment) {
        cR.save(comment);
    }

    //답변 조회
    public List<CommentEntity> commentList() {
        return cR.findAll();
    }

    //답변 삭제
    public void deleteComment(Integer id) {
        cR.deleteById(id);
    }

}
