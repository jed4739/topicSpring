package com.example.topicSpring.service;

import com.example.topicSpring.domain.Member;
import com.example.topicSpring.domain.dto.MemberDTO;
import com.example.topicSpring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member InsertMember(MemberDTO memberDTO) throws Exception {
        Member member = Member.builder()
                .id(memberDTO.getId())
                .username(memberDTO.getUsername())
                .password(passwordEncoder.encode(memberDTO.getPassword()))
                .email(memberDTO.getEmail())
                .build();
        // 중복 체크


        // 모두 완료후 회원가입
        return memberRepository.save(member);
    }

}
