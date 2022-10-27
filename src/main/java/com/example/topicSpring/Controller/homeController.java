package com.example.topicSpring.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class homeController {
    @GetMapping("/")
    public String home(Model model){
        log.info("Get : home");
        return "/index";
    }
    @GetMapping("/user")
    public String User(Model model){
        log.info("Get : User page");
        return "/user/user";
    }
    @GetMapping("/admin")
    public String Admin(Model model){
        log.info("Get : Admin page");
        return "/user/admin";
    }
}
