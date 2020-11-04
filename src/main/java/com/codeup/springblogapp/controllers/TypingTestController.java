package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TypingTestController {

    @GetMapping("/javascript_typing_test/javascript_typing_test")
    public String typingTestPage() {
        return "/javascript_typing_test/javascript_typing_test";
    }
}
