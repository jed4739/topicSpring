package com.example.topicSpring.service;

import com.example.topicSpring.domain.Member;
import com.example.topicSpring.error.DataNotFoundException;
import com.example.topicSpring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member save(String username, String email, String password) throws Exception {
        Member member = new Member();
        member.setUsername(username);
        member.setEmail(email);
        member.setPassword(passwordEncoder.encode(password));
        member.setRole("USER");
        this.memberRepository.save(member);
        return member;
    }

    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public Member getMember(String username) {
        Optional<Member> member = this.memberRepository.findByUsername(username);
        if (member.isPresent()) {
            return member.get();
        }else {
            throw new DataNotFoundException("member not found");
        }
    }
}
