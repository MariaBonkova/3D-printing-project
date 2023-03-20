package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CreateItemController {

    @GetMapping("/create-item-form")
    public String createItemForm(){
        return "create-item-form";
    }
}
