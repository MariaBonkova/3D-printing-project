package com.example.demo.web;

import org.springframework.stereotype.Controller;
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

    @GetMapping("/materials")
    public String materials() {
        return "materials";
    }

    @GetMapping("/house-catalog")
    public String houseCatalog() {
        return "house-catalog";
    }

    @GetMapping("/music-catalog")
    public String musicCatalog() {
        return "music-catalog";
    }

    @GetMapping("/pets-catalog")
    public String petCatalog() {
        return "pets-catalog";
    }
}
