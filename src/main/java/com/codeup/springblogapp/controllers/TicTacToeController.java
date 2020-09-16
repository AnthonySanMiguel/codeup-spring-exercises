package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicTacToeController {

    @GetMapping("/tictactoe/tictactoe")
    public String ticTacToePage() {
        return "react_tictactoe";
    }
}
