package com.example.topicSpring.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {
    private Long id;
    private String username;
    private String email;
    private String password;

    public MemberDTO(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
