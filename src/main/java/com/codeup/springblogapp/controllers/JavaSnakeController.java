package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class JavaSnakeController {

    @GetMapping("/java_snake_tutorial/java_snake_tutorial")
    public String JavaSnakePage() {
        return "/java_snake_tutorial/java_snake_tutorial";
    }
}
