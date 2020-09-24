package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReactPianoController {

    @GetMapping("/react_piano/react_piano")
    public String ReactPianoPage() {
        return "/react_piano/react_piano";
    }
}
