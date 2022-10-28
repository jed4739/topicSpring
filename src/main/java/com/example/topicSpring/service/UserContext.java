package com.example.topicSpring.service;

import com.example.topicSpring.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserContext extends User {
    private final User user;

    public UserContext(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUserid(), user.getUser_password(), authorities);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
