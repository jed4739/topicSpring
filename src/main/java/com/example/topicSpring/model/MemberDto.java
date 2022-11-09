package com.example.topicSpring.model;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/** DTO */
@Getter @Setter
public class MemberDto {

    @NotEmpty(message = "아이디(닉네임)는 필수 항목 입니다.")
    @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 4~20자리여야 합니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수 항목 입니다.")
    @Pattern(regexp = "^[A-Za-z0-9]{4,20}$", message = "비밀번호는 영어와 숫자만 사용하여 4~20자리여야 합니다.")
    private String password_1;

    @NotEmpty(message = "비밀번호 확인은 필수 항목 입니다.")
    @Pattern(regexp = "^[A-Za-z0-9]{4,20}$", message = "비밀번호 확인은 영어와 숫자만 사용하여 4~20자리여야 합니다.")
    private String password_2;

    @Email
    @NotEmpty(message = "이메일은 필수 항목 입니다.")
    private String email;

}
