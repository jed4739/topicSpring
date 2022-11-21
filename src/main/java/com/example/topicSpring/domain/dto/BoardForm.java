package com.example.topicSpring.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class BoardForm {

    @NotBlank(message = "제목은 필수입니다")
    @Size(max = 200)
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}
