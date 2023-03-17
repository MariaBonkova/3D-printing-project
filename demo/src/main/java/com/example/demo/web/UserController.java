package com.example.demo.web;

import com.example.demo.models.dto.UserLoginDto;
import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.service.AuthService;
import com.example.demo.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
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

    private final UserServiceImpl userServiceImpl;
    private final ModelMapper modelMapper;
    private final AuthService authService;
    private DelegatingSecurityContextRepository securityContextRepository;

    public UserController(
            UserServiceImpl userServiceImpl, ModelMapper modelMapper, AuthService authService) {
        this.userServiceImpl = userServiceImpl;
        this.modelMapper = modelMapper;
        this.authService = authService;
    }

    @ModelAttribute("userRegisterDto")
    private UserRegisterDto initRegisterDto(){
        return new UserRegisterDto();
    }
    @ModelAttribute("userLoginDto")
    private UserLoginDto initLoginDto(){
        return new UserLoginDto();
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("bad_credentials")) {
            model.addAttribute("bad_credentials", true);
        }
        return "login";
    }


    @PostMapping("/users/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String userName,
            RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, userName);
        redirectAttributes.addFlashAttribute("bad_credentials", true);

        return "redirect:login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("isFound")) {
            model.addAttribute("isFound", true);
        }
        return "/register";
    }

    @PostMapping("/register")
    public String registerPost(HttpServletRequest request,
                               HttpServletResponse response,
                               @Valid UserRegisterDto userRegisterDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !this.authService.register(userRegisterDto)) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto", bindingResult)
                    .addFlashAttribute("isFound",false);


            return "redirect:register";
        }
        userServiceImpl.registerUser(userRegisterDto, successfulAuth -> {

            // populating security context
            SecurityContextHolderStrategy strategy = SecurityContextHolder.getContextHolderStrategy();

            SecurityContext context = strategy.createEmptyContext();
            context.setAuthentication(successfulAuth);

            strategy.setContext(context);


            securityContextRepository.saveContext(context, request, response);
        });

        return "redirect:/users/login";

    }






}