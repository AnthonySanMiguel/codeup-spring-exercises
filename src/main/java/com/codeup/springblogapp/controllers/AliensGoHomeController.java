package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AliensGoHomeController {

    @GetMapping("/react_aliens_go_home/react_aliens_go_home")
    public String aliensGoHomePage() {
        return "/react_aliens_go_home/react_aliens_go_home";
    }
}
