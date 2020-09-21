package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HangmanController {

    @GetMapping("/python_hangman/python_hangman")
    public String HangmanPage() {
        return "/python_hangman/python_hangman";
    }
}
