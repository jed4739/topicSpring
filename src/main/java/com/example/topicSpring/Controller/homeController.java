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
        log.info("Get : home controller");
        return "index";
    }
    @GetMapping("/user")
    public String displayUser(Model model){
        log.info("home controller");
        return "/user/user";
    }
    @GetMapping("/manager")
    public String displayManager(Model model){
        log.info("home controller");
        return "/user/manager";
    }
    @GetMapping("/admin")
    public String displayAdmin(Model model){
        log.info("home controller");
        return "/user/admin";
    }
}
