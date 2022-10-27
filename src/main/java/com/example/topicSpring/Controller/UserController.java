package com.example.topicSpring.Controller;

import com.example.topicSpring.DTO.UserForm;
import com.example.topicSpring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;

    @GetMapping("/register")
    public String createUserForm(Model model){
        model.addAttribute("userForm",new UserForm());
        return "user/login/register";
    }

    @PostMapping("/register")
    public String createUser(@Validated UserForm form, BindingResult result){
        if(result.hasErrors()){
            return "user/login/register";
        }
        userService.createUser(form);
        log.error("500");
        return "redirect:/";
    }

}
