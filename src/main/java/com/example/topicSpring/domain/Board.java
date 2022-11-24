package com.example.topicSpring.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
// (access = AccessLevel.PROTECTED)
public class Board extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

//    @Builder
//    public Board(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }
}
