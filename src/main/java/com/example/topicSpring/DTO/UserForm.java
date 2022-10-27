package com.example.topicSpring.DTO;

import com.example.topicSpring.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private Long id;
    private String userid;
    private String mail;
    private String user_password;
    private String name;
    private String phone;
    private String created;
    private String role;


    public User toEntity() {
        return User.builder()
                .id(id)
                .userid(userid)
                .mail(mail)
                .user_password(new BCryptPasswordEncoder().encode(user_password))
                .name(name)
                .phone(phone)
                .created(created)
                .role(role)
                .build();
    }
}

