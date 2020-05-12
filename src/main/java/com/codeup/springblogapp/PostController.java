package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    // View all posts
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String getPosts(Model model) {
        ArrayList<Post> allPosts = new ArrayList<Post>();
        Post singlePost = new Post("2011 Chevrolet Camaro", "Low mileage, black");
        allPosts.add(singlePost);
        singlePost= new Post("2015 Apple MacBook Air", "Excellent condition.");
        allPosts.add(singlePost);
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }

//    // View an individual post (by ID)
//    @RequestMapping(path = "/posts/show", method = RequestMethod.GET)
//    @ResponseBody
//    public String getPostById(int id) {
//        return "Viewing individual post: " + id;
//    }

    // View an individual post (by type)
    @RequestMapping(path = "/posts/show", method = RequestMethod.GET)
    public String getIndividualPost(Model model) {
        Post singlePost = new Post("NES console (Works great)", "Comes with two controllers and zapper!");
        model.addAttribute("singlePost", singlePost);
        return "posts/show";
    }

    // View create post form
    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String viewPostForm() {
        return "VIEW the form for creating a post.";
    }

    // Submit create post form
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPostForm() {
        return "COMPLETE + SUBMIT the form for creating a post.";
    }
}
