package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpaceInvadersController {

    @GetMapping("/react_space_invaders/react_space_invaders")
    public String reactSpaceInvadersPage() {
        return "/react_space_invaders/react_space_invaders";
    }
}
