package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PongController {

    @GetMapping("/javascript_pong/javascript_pong")
    public String javascriptPongPage() {
        return "/javascript_pong/javascript_pong";
    }
}
