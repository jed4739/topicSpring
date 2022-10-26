package com.example.topicSpring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "author")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(length = 100, name = "userid", unique = true)
    private String userid;

    @Column(length = 100, name = "mail", unique = true)
    private String mail;

    @Column(length = 100, name = "userPassword")
    private String userPassword;

    @Column(length = 15, name = "name")
    private String name;

    @Column(length = 100, name = "profile")
    private String profile;

    @Column(length = 20, name = "phone")
    private String phone;

    @Column(name = "created")
    private String created;


    private String role;

}
