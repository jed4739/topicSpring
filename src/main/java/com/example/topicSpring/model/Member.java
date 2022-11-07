package com.example.topicSpring.model;

import lombok.*;
import javax.persistence.*;


@Getter @Setter
@Entity
@Table(name = "member")
public class Member extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false, name = "username", unique = true)
    private String username;

    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;
}

