package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BreakoutController {

    @GetMapping("/breakout_game/breakout_index")
    public String breakoutPage() {
        return "/breakout_game/breakout_index";
    }
}
