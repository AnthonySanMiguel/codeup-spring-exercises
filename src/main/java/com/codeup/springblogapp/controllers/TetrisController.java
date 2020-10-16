package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TetrisController {

    @GetMapping("/javascript_tetris/javascript_tetris")
    public String javascriptTetrisPage() {
        return "/javascript_tetris/javascript_tetris";
    }
}
