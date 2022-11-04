package com.example.topicSpring.model;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class MemberCreateForm {

    @Size(min = 3, max = 25)
    @NotEmpty(message = "ID는 필수 항목 입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수 항목 입니다.")
    private String password_1;

    @NotEmpty(message = "비밀번호 확인은 필수 항목 입니다.")
    private String password_2;

    @Email
    @NotEmpty(message = "이메일은 필수 항목 입니다.")
    private String email;

}
