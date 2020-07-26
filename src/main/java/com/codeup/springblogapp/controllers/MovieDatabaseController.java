package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieDatabaseController {

    @GetMapping("/movie_database/movie_database")
    public String MovieDatabasePage() {
        return "/movie_database/movie_database";
    }
}
