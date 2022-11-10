package com.example.topicSpring.domain;

import lombok.*;
import javax.persistence.*;


@Getter @Setter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, name = "username", unique = true)
    private String username;

    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

}

