package com.example.demo.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   @GetMapping("/home")
    public String home() {
        return "home";
    }


    @GetMapping("/admins")
    public String admins() {
        return "admins";
    }

    @GetMapping("/moderator")
    public String moderator() {
        return "moderator";
    }
}
