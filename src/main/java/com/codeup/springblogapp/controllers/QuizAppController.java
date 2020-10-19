package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuizAppController {

    @GetMapping("/js_quiz_app/js_quiz_app")
    public String quizAppPage() {
        return "/js_quiz_app/js_quiz_app";
    }
}
