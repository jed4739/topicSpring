package com.example.topicSpring.domain.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter @Setter
public class MemberSaveForm {

    private Long id;

    @NotBlank(message = "아이디(닉네임)는 필수 항목 입니다.")
    @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 4~20자리여야 합니다.")
    private String username;

    @NotBlank(message = "비밀번호는 필수 항목 입니다.")
    @Pattern(regexp = "^[A-Za-z0-9]{4,20}$", message = "비밀번호는 영어와 숫자만 사용하여 4~20자리여야 합니다.")
    private String password;

    @Email
    @NotBlank(message = "이메일은 필수 항목 입니다.")
    private String email;

}
