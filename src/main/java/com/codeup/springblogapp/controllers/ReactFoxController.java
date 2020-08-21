package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReactFoxController {

    @GetMapping("/reactfox_tutorial/reactfox_tutorial")
    public String ReactFoxPage() {
        return "/reactfox_tutorial/reactfox_tutorial";
    }
}
