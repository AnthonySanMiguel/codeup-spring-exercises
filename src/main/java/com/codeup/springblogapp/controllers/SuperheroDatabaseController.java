package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SuperheroDatabaseController {

    @GetMapping("/superhero_database/superhero_database")
    public String SuperheroDatabasePage() {
        return "/superhero_database/superhero_database";
    }
}
