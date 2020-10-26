package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BubbleShooterController {

    @GetMapping("/bubble_shooter/bubble_shooter")
    public String bubbleShooterPage() {
        return "/bubble_shooter/bubble_shooter";
    }
}
