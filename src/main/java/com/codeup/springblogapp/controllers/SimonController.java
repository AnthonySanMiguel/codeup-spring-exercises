package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SimonController {

    @GetMapping("/javascript_simon/javascript_simon")
    public String simonPage() {
        return "/javascript_simon/javascript_simon";
    }
}
