package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // dictates that this class is a controller (in MVC)
public class HelloController {

//    @RequestMapping(path = "/", method = RequestMethod.GET) // if a user is visting "localhost:8080/" with a GET request (more explicit version)
//    @GetMapping("/") // when users visit "localhost:8080/"
//    @ResponseBody // return the string as HTML
//    public String hello(){
//        return "Index page.";
//    }

    @GetMapping("/hello")
    @ResponseBody
    public String helloSpring(){
        return "<h2><em>Hello from Spring!</h2></em>";
    }

//    @RequestMapping(path = "/upload", method = RequestMethod.POST)
//    @PostMapping("/upload")
//    public void upload(){
//        // do something for uploading
//    }

    // *** PATH VARIABLES *** //

    @GetMapping("/hi/{name}") // When users visit "localhost:8080/hi/[type string here]"
    @ResponseBody
    public String sayHi(@PathVariable String name) { // Variable name must match name defined in method parameter!
        return "Hi, " + name;
    }

    @GetMapping("/defined-ad/{id}")
    @ResponseBody
    public String showAd(@PathVariable long id){
        return "showing details for ad with id: " + id;
    }

//    Lecture

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

    @GetMapping("/welcome")
    public String showWelcome() {
        return "welcome";
    }
}
