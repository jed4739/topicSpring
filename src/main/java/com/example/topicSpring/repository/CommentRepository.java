package com.example.topicSpring.repository;

import com.example.topicSpring.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
