package com.example.safeteenbackend.domain.comment.service;

import com.example.safeteenbackend.domain.board.entity.Board;
import com.example.safeteenbackend.domain.board.exception.BoardNotFound;
import com.example.safeteenbackend.domain.board.repository.BoardRepository;
import com.example.safeteenbackend.domain.comment.controller.dto.request.CommentRequest;
import com.example.safeteenbackend.domain.comment.controller.dto.response.CommentResponse;
import com.example.safeteenbackend.domain.comment.entity.CommentEntity;
import com.example.safeteenbackend.domain.comment.repository.CommentRepository;
import com.example.safeteenbackend.domain.user.entity.User;
import com.example.safeteenbackend.domain.user.exception.UserNotFoundException;
import com.example.safeteenbackend.domain.user.repository.UserRepository;
import com.example.safeteenbackend.global.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository cR;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    //답변 작성
    public CommentResponse write(CommentRequest comment) {
        User user = userRepository.findByEmail(SecurityUtil.getEmail()).orElseThrow(UserNotFoundException::new);
        Board board = boardRepository.findById(comment.getBoard_id()).orElseThrow(BoardNotFound::new);
        CommentEntity commentEntity = CommentEntity.builder()
                .content(comment.getContent())
                .user(user)
                .board(board)
                .createCommentTime(LocalDateTime.now())
                .build();
        cR.save(commentEntity);

        return CommentResponse.builder()
                .content(comment.getContent())
                .createCommentTime(commentEntity.getCreateCommentTime())
                .build();
    }

    //답변 삭제
    public void deleteComment(Integer id) {
        cR.deleteById(id);
    }

}
