package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CoffeeController {

    @GetMapping("/coffee_project/coffee")
    public String coffeePage() {
        return "/coffee_project/coffee";
    }
}
