package com.example.topicSpring.constroller;

import com.example.topicSpring.model.MemberCreateForm;
import com.example.topicSpring.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup(@ModelAttribute("memberCreateForm") MemberCreateForm memberCreateForm) {
        return "login/signUp_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("memberCreateForm")  MemberCreateForm memberCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login/signUp_form";
        }

        if (!memberCreateForm.getPassword_1().equals(memberCreateForm.getPassword_2())) {
            bindingResult
                    .rejectValue(
                            "password_2",
                            "passwordInCorrect",
                            "2개의 패스워드가 일치하지 않습니다."
                    );
            return "login/signUp_form";
        }

        try {
            memberService.create(memberCreateForm.getUsername(), memberCreateForm.getEmail(), memberCreateForm.getPassword_1());
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject(
                    "signupFailed",
                    "이미 등록된 사용자입니다.");
            log.info("등록된 회원입니다.");
            return "login/signUp_form";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject(
                    "signupFailed", e.getMessage());
            log.info("로그인 실패 ㅠ");
            return "login/signUp_form";
        }
        log.info("회원가입 성공!!");
        return "login/login_form";
    }

    @GetMapping("/login")
    public String login() {
        log.info("로그인 페이지 접근!");
        return "login/login_form";
    }

    @GetMapping("/mypage")
    public String mypage(Principal principal) {
        log.info("마이 페이지");
        return "my_page";
    }
}
