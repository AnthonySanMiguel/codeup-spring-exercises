package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HangmanController {

    @GetMapping("/hangman/hangman")
    public String HangmanPage() {
        return "/hangman/hangman";
    }
}
