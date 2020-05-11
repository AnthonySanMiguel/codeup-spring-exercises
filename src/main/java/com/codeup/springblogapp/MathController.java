package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/") // when users visit "localhost:8080/"
    @ResponseBody
    public String mathWelcome() {
        return "Main math page.";
    }

    @GetMapping("/add/{numberA}/and/{numberB}")
    @ResponseBody
    public int add(@PathVariable int numberA, @PathVariable int numberB) {
        return numberA + numberB;
    }

    @GetMapping("/subtract/{numberB}/from/{numberA}")
    @ResponseBody
    public int subtract(@PathVariable int numberA, @PathVariable int numberB) {
        return numberB - numberA;
    }

    @GetMapping("/multiply/{numberA}/and/{numberB}")
    @ResponseBody
    public int multiply(@PathVariable int numberA, @PathVariable int numberB) {
        return numberA * numberB;
    }

    @GetMapping("/divide/{numberA}/by/{numberB}")
    @ResponseBody
    public int divide(@PathVariable int numberA, @PathVariable int numberB) {
        return numberA / numberB;
    }

    // Instructor solution
    @GetMapping("/{operation}/{numberA}/{keyword}/{numberB}")
    @ResponseBody
    public String doMath(@PathVariable String operation, @PathVariable int numberA, @PathVariable String keyword, @PathVariable int numberB) {
        switch (operation) {
            case "add":
                int sum;
                sum = numberA + numberB;
                return Integer.toString(sum);

            case "subtract":
                int diff;
                diff = numberB - numberA;
                return Integer.toString(diff);

            case "multiply":
                int product;
                product = numberA * numberB;
                return Integer.toString(product);

            case "divide":
                int quotient;
                quotient = numberA / numberB;
                if (numberA % numberB != 0) {
                    int remainder = numberA % numberB;
                    return Integer.toString(quotient) + " remainder " + Integer.toString(remainder);
                } else {
                    return Integer.toString(quotient);
                }
            default:
                return "Ed Sheeran hasn't written this album yet.";
        }
    }
}
