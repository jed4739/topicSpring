package com.example.topicSpring.domain;

import lombok.Getter;

@Getter
public enum MemberRole {
    USER("ROLE_USER");

    MemberRole(String value) {
        this.value = value;
    }

    private String value;

}