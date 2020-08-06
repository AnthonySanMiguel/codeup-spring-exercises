package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExoPlanetController {

    @GetMapping("/exoplanet/exoplanet")
    public String exoPlanetPage() {
        return "/exoplanet/exoplanet";
    }
}
