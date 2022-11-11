package com.example.topicSpring.constroller;

import com.example.topicSpring.domain.MemberDto;
import com.example.topicSpring.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup(@ModelAttribute("memberCreateForm") MemberDto memberDto) {
        return "login/signUp_form";
    }

    /*
    * 회원가입 메소드
    * DTO에서 값을 받음.
    * Error구현
    * */
    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("memberCreateForm") MemberDto memberDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("MemberCreateForm",memberDto);
            return "login/signUp_form";
        }

        if (!memberDto.getPassword_1().equals(memberDto.getPassword_2())) {
            bindingResult
                    .rejectValue(
                            "password_2",
                            "passwordInCorrect",
                            "2개의 패스워드가 일치하지 않습니다."
                    );
            return "login/signUp_form";
        }
            memberService.create(memberDto.getUsername(), memberDto.getEmail(), memberDto.getPassword_1());
        return "login/login_form";
    }

    @GetMapping("/login")
    public String login() {
        log.info("로그인 페이지 접근!");
        return "login/login_form";
    }

    @GetMapping("/mypage")
    public String mypage() {
        log.info("마이 페이지");
        return "my_page";
    }

}
