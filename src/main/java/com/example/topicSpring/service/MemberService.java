package com.example.topicSpring.service;

import com.example.topicSpring.domain.Member;
import com.example.topicSpring.domain.dto.DTO;
import com.example.topicSpring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(DTO memberDTO) throws Exception {
        Member member = Member.builder()
                .id(memberDTO.getId())
                .username(memberDTO.getUsername())
                .password(passwordEncoder.encode(memberDTO.getPassword()))
                .email(memberDTO.getEmail())
                .build();
        memberRepository.save(member);
    }
}
