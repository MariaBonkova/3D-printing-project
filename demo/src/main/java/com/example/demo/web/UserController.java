package com.example.demo.web;

import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final AuthService authService;

    public UserController(UserService userService, ModelMapper modelMapper, AuthService authService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.authService = authService;
    }
    @ModelAttribute("userRegisterDto")
    private UserRegisterDto initRegisterDto(){
        return new UserRegisterDto();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost( ) {
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("isFound")) {
            model.addAttribute("isFound", true);
        }
        return "/register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid UserRegisterDto userRegisterDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !this.authService.register(userRegisterDto)) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto", bindingResult)
                    .addFlashAttribute("isFound",false);


            return "redirect:register";
        }
        return "redirect:/users/login";

    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }




}