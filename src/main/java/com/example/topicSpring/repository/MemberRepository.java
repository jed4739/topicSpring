package com.example.topicSpring.repository;

import com.example.topicSpring.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
     Optional<Member> findByUsername(String username);

     boolean existsByUsername(String username);

     boolean existsByEmail(String email);
}
