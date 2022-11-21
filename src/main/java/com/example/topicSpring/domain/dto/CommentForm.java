package com.example.topicSpring.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class CommentForm {

    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}
