package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SnakeController {

    @GetMapping("/snake_tutorial/snake_tutorial")
    public String SnakePage() {
        return "/snake_tutorial/snake_tutorial";
    }
}
