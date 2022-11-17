package com.example.topicSpring.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Comment extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private Board board;
}
