package com.example.topicSpring.constroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign")
public class HomeController {
    @GetMapping("/up")
    public String SignUp(){
        return "dd";
    }
}
