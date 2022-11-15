package com.example.topicSpring.constroller;

import com.example.topicSpring.domain.dto.MemberDTO;
import com.example.topicSpring.domain.dto.MemberSaveForm;
import com.example.topicSpring.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public String signup(Model model) {
        model.addAttribute("memberCreateForm", new MemberSaveForm());
        log.info("회원가입 페이지로 이동");
        return "login/signUp_form";
    }

    /*
    * 회원가입 메소드
    * DTO에서 값을 받음.
    * Error구현
    * */
    @PostMapping("/signup")
    public String signup(@Valid MemberSaveForm memberSaveForm, BindingResult bindingResult) throws Exception{

        if (bindingResult.hasErrors()) {
            log.info("회원가입 중 에러", bindingResult);
            return "login/signUp_form";
        }
        /*
        * DTO 생성자에 VO 세팅
        * */
        MemberDTO memberDTO = new MemberDTO(
                memberSaveForm.getId(),
                memberSaveForm.getUsername(),
                memberSaveForm.getPassword(),
                memberSaveForm.getEmail()
        );
        log.info("MemberDTO ={}", memberDTO);

        /*
         * 3. 회원 가입 정보 DTO를 Controller -> Service 전달
         */
        memberService.InsertMember(memberDTO);
        return "login/signIn_form";
    }

    @GetMapping("/login")
    public String login() {
        log.info("로그인 페이지 접근!");
        return "login/signIn_form";
    }

    @GetMapping("/mypage")
    public String mypage() {
        log.info("마이 페이지");
        return "my_page";
    }

}
