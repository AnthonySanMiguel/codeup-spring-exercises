package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class JavaPacmanController {

    @GetMapping("/java_pacman_tutorial/java_pacman_tutorial")
    public String JavaPacmanPage() {
        return "/java_pacman_tutorial/java_pacman_tutorial";
    }
}
