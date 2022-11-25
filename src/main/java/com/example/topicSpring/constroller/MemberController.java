package com.example.topicSpring.constroller;

import com.example.topicSpring.domain.dto.MemberSignUpForm;
import com.example.topicSpring.domain.dto.SignInForm;
import com.example.topicSpring.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Hashtable;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {

    public static Hashtable sessionList = new Hashtable();
    private final MemberService memberService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("memberCreateForm", new MemberSignUpForm());
        log.info("회원가입 페이지로 이동");
        return "login/signUp_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute MemberSignUpForm memberSignUpForm, BindingResult bindingResult) throws Exception {

        try {
            if (bindingResult.hasErrors()) {
                log.info("SignUp error");
                return "login/signUp_form";
            }
            if (!memberSignUpForm.getPassword1().equals(memberSignUpForm.getPassword2())) {
                bindingResult.rejectValue("password2", "passwordInCorrect", "두개의 패스워드가 일치하지 않습니다.");
                return "login/signIn_form";
            }
            if (memberService.findByUsername(memberSignUpForm.getUsername()).isPresent()) {
                bindingResult.rejectValue("username", "signupFail", "이미 존재하는 아이디 입니다.");
            }
            if (memberService.findByEmail(memberSignUpForm.getEmail()).isPresent()) {
                bindingResult.rejectValue("email", "signupFail", "이미 존재하는 이메일 입니다.");
            }
            memberService.save(memberSignUpForm.getUsername(), memberSignUpForm.getEmail(), memberSignUpForm.getPassword1());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다");
            return "login/signUp_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "login/signIn_form";
        }
        return "login/signIn_form";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute SignInForm signInForm) {
        log.info("로그인 페이지 접근!");
        return "login/signIn_form";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            sessionList.remove(session.getId());
            session.invalidate();
        }
        model.addAttribute("msg", "로그아웃 되었습니다!");
        model.addAttribute("url", "/");
        return "message";
    }
//
//    @GetMapping("/delete")
//    public String delete(@ModelAttribute SignInForm signInForm, @AuthenticationPrincipal PrincipalDetail principalDetail) {
//        return "delete_form";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute SignInForm signInForm, Model model, HttpServletRequest request, @AuthenticationPrincipal PrincipalDetail principalDetail) {
//        Member member = principalDetail.getMember();
//        if (!bCryptPasswordEncoder.matches(signInForm.getPassword(), member.getPassword())) {
//            model.addAttribute("msg", "비밀번호가 틀렸습니다.");
//            model.addAttribute("url", "/user/delete");
//            return "message";
//        }
//        memberService.delete(member.getId());
//        HttpSession session = request.getSession(false);
//        if(session != null) {
//            sessionList.remove(session.getId());
//            session.invalidate();
//        }
//        model.addAttribute("msg","회원탈퇴 되었습니다.");
//        model.addAttribute("url","/");
//        return "message";
//    }
//
}
