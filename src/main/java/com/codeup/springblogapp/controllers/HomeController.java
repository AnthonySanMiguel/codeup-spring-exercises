package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

//    @GetMapping("/") // Comment out direct to single slash "/" so there is no conflict with this file, HelloController, and MathController
//    @ResponseBody
//    public String sayHello(){
//        return "This is the landing page!";
//    }

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }
}