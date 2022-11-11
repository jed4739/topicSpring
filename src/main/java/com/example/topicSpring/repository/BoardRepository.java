package com.example.topicSpring.repository;

import com.example.topicSpring.domain.Board;
import com.example.topicSpring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board, Long> {
}
