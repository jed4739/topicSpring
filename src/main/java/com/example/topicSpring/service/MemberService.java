package com.example.topicSpring.service;

import com.example.topicSpring.domain.Member;
import com.example.topicSpring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /*
    * MemberRepository 를 통해 Nickname, Email, Password 를 Member 에 전달
    * password 의 경우, Bean 으로 등록한 PasswordEncoder 로 비밀번호를 해쉬하여 전달
    * */
    public Member create(String username, String email, String password) {
        Member member = new Member();
        member.setUsername(username);
        member.setEmail(email);
        member.setPassword(passwordEncoder.encode(password));
        this.memberRepository.save(member);
        return member;
    }

}
