package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReactTodoController {

    @GetMapping("/react_todo_tutorial/react_todo_tutorial")
    public String ReacttTodoPage() {
        return "/react_todo_tutorial/react_todo_tutorial";
    }
}
