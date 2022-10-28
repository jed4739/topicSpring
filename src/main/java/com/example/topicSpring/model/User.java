package com.example.topicSpring.model;

import lombok.*;
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
    private String user_password;

    @Column(length = 15, name = "name")
    private String name;

    @Column(name = "created")
    private String created;

    @Column(name = "role")
    private String role;

    @Builder
    public User(Integer id, String userid,String mail, String user_password, String name, String created, String role) {
        this.id = id;
        this.userid = userid;
        this.mail = mail;
        this.user_password = user_password;
        this.name = name;
        this.created = created;
        this.role = role;

    }

    public User(String userid, String user_password, Collection<? extends GrantedAuthority> authorities) {
    }
}

