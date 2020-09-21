package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TextGameController {

    @GetMapping("/text_adventure_game/text_adventure_game")
    public String TextGamePage() {
        return "text_adventure_game/text_adventure_game";
    }
}
