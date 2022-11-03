package com.example.topicSpring.repository;

import com.example.topicSpring.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BordRepository extends JpaRepository<Board,Integer> {
}
