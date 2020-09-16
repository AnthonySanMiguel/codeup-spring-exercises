package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReactMetronomeController {

    @GetMapping("/react_metronome/react_metronome")
    public String ReactMetronomePage() {
        return "/react_metronome/react_metronome";
    }
}
