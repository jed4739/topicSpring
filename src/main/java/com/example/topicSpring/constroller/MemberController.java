package com.example.topicSpring.constroller;

import com.example.topicSpring.model.MemberCreateForm;
import com.example.topicSpring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
            bindingResult.rejectValue("password_2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "login/signUp_form";
        }

        memberService.create(memberCreateForm.getUsername(),
                memberCreateForm.getEmail(), memberCreateForm.getPassword_1());

        return "redirect:/";
    }
}
