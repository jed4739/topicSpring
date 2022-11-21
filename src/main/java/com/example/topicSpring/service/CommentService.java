package com.example.topicSpring.service;

import com.example.topicSpring.domain.Board;
import com.example.topicSpring.domain.Comment;
import com.example.topicSpring.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void create(Board board, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setBoard(board);
        this.commentRepository.save(comment);
    }
}
