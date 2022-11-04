package com.example.topicSpring.repository;

import com.example.topicSpring.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
