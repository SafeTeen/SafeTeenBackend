package com.example.safeteenbackend.domain.comment.repository;

import com.example.safeteenbackend.domain.comment.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
}
