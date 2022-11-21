package com.example.topicSpring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
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
