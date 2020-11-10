package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class InfiniteMarioController {

    @GetMapping("/infinite_mario/infinite_mario")
    public String infiniteMarioPage() {
        return "/infinite_mario/infinite_mario";
    }
}
