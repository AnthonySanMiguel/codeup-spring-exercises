package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReactCalculatorController {

    @GetMapping("/react_calculator/react_calculator")
    public String reactCalculatorPage() {
        return "/react_calculator/react_calculator";
    }
}
