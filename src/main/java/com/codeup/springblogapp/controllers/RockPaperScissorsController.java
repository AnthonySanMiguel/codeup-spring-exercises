package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RockPaperScissorsController {

    @GetMapping("/rock_paper_scissors_tutorial/rock_paper_scissors_tutorial")
    public String rockPaperScissorsPage() {
        return "/rock_paper_scissors_tutorial/rock_paper_scissors_tutorial";
    }
}
