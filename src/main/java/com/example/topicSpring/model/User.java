package com.example.topicSpring.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "author")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(length = 100, name = "username", unique = true)
    private String userid;

    @Column(length = 100, name = "mail", unique = true)
    private String mail;

    @Column(length = 100, name = "password")
    private String password;

    @Column(length = 15, name = "name")
    private String name;

    @Column(name = "created")
    @CreatedDate
    private String created;

    @Column(name = "role")
    private String role;

    @Builder
    public User(Integer id, String userid,String mail, String password, String name, String role) {
        this.id = id;
        this.userid = userid;
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.role = role;

    }

}

