package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReactCompassClockController {

    @GetMapping("/react_compass_clock/react_compass_clock")
    public String ReactCompassClockPage() {
        return "/react_compass_clock/react_compass_clock";
    }
}
