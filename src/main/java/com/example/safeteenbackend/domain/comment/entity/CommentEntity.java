package com.example.safeteenbackend.domain.comment.entity;

import com.example.safeteenbackend.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@Entity(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createCommentTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
