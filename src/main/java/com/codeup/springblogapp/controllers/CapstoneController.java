package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CapstoneController {

    @GetMapping("/capstone/capstone")
    public String capstonePage() {
        return "/capstone/capstone";
    }
}
