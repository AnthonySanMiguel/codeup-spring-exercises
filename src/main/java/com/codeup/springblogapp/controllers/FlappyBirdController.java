package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FlappyBirdController {

    @GetMapping("/flappy_bird/flappy_bird")
    public String flappyBirdPage() {
        return "/flappy_bird/flappy_bird";
    }
}
