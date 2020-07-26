package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TextGameController {

    @GetMapping("/text_game/text_game")
    public String TextGamePage() {
        return "/text_game/text_game";
    }
}
