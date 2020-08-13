package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {

    @GetMapping("/dice_game/roll_dice")
    public String diceGreeter() {
        return "/dice_game/roll_dice";
    }

    @GetMapping("/roll_dice/{guessedNumber}")
    public String diceRoller(@PathVariable int guessedNumber, Model model) {

        int randomNumber = (int) Math.floor(Math.random() * 10 + 1);
        model.addAttribute("userGuess", guessedNumber);
        model.addAttribute("randomSelection", randomNumber);
        return "/dice_game/roll_dice_results";
    }
}
