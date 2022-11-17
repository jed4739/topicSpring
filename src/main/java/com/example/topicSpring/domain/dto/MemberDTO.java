package com.example.topicSpring.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MemberDTO {
    private String username;
    private String email;
    private String password;

    public MemberDTO(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
