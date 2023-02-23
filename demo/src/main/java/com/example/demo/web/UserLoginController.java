package com.example.demo.web;
import com.example.demo.models.dto.UserLoginDto;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {

    private final  UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/login")
    public String login() {
        return "login";
    }




    @PostMapping("/user/login")
    public String login(UserLoginDto userLoginDto) {
        System.out.println("User is logged: " + userService.login(userLoginDto));
        return "redirect:/home";
    }

}