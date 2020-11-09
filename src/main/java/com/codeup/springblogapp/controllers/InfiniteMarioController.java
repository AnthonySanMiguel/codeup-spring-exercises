package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class InfiniteMarioController {

    @GetMapping("/infinite_mario/main")
    public String aliensGoHomePage() {
        return "/infinite_mario/main";
    }
}
