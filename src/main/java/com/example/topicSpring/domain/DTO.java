package com.example.topicSpring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class DTO {
    private Long id;
    private String username;
    private String email;
    private String password;

    public DTO(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
