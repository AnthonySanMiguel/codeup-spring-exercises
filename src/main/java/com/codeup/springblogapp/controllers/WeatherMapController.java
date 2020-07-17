package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeatherMapController {

    @GetMapping("/weather_map/weather_map")
    public String weatherMapPage() {
        return "/weather_map/weather_map";
    }
}
