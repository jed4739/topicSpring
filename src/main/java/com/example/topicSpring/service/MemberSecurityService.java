package com.example.topicSpring.service;

import com.example.topicSpring.model.Member;
import com.example.topicSpring.model.MemberRole;
import com.example.topicSpring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService {
    private final MemberRepository memberRepository;
    /*
    * 사용자의 이름(MemberRepository)으로 비밀번호를 조회하여 리턴하는 메소드
    * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> member_ = this.memberRepository.findByUsername(username);
        if(member_.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        Member member = member_.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(username)) {
            log.info("어드민 계정 생성");
            authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
        } else {
            log.info("유저 계정 생성");
            authorities.add(new SimpleGrantedAuthority(MemberRole.USER.getValue()));
        }
        log.info("사용자이름 비밀번호 권한 리턴");
        return new User(member.getUsername(), member.getPassword(), authorities);
    }
}
