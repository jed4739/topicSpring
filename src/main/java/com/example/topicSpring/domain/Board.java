package com.example.topicSpring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class Board extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

}
