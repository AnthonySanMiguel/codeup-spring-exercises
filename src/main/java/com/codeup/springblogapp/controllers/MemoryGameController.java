package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemoryGameController {

    @GetMapping("/memory_game/memory_game")
    public String MemoryGamePage() {
        return "/memory_game/memory_game";
    }
}
