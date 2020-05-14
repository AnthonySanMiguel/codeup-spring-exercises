package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Post;
import com.codeup.springblogapp.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postRepo;

    public PostController(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    // View all posts
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String getPosts(Model model) {
//        ArrayList<Post> allPosts = new ArrayList<Post>();
//        Post singlePost = new Post("2011 Chevrolet Camaro", "Low mileage, black");
//        allPosts.add(singlePost);
//        singlePost= new Post("2015 Apple MacBook Air", "Excellent condition.");
//        allPosts.add(singlePost);
//        model.addAttribute("allPosts", allPosts);
        List<Post> allPosts = postRepo.findAll();
        model.addAttribute("posts", allPosts);
        return "posts/index";
    }

//    // View an individual post (by ID)
//    @RequestMapping(path = "/posts/show", method = RequestMethod.GET)
//    @ResponseBody
//    public String getPostById(int id) {
//        return "Viewing individual post: " + id;
//    }

    // View an individual post (by type)
    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String getIndividualPost(@PathVariable long id, Model model) {
//        Post singlePost = new Post("NES console (Works great)", "Comes with two controllers and zapper!");
//        model.addAttribute("singlePost", singlePost);
        Post singlePost = postRepo.getOne(id);
        model.addAttribute("post", singlePost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost() {
        return "posts/create";
    }

//    // View create post form
//    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
//    @ResponseBody
//    public String viewPostForm() {
//        return "VIEW the form for creating a post.";
//    }

    // Submit create post form
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String submitCreatePost(@RequestParam String title, @RequestParam String body) {
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);
        newPost = this.postRepo.save(newPost);
        System.out.println("id:" + newPost.getId() + ", title:" + newPost.getTitle());
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String getEditPostForm(@PathVariable long id, Model model){
        Post singlePost = postRepo.getOne(id);
        model.addAttribute("post", singlePost);
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String savePostEdit(@PathVariable long id, @RequestParam String title, @RequestParam String body, Model model){
        Post editPost = postRepo.getOne(id);

        editPost.setTitle(title);
        editPost.setBody(body);
        postRepo.save(editPost);

        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String getDeletePostForm(@PathVariable long id, Model model){
        Post singlePost = postRepo.getOne(id);
        model.addAttribute("post", singlePost);
        return "posts/delete";
    }
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        Post singlePost = postRepo.getOne(id);
        postRepo.delete(singlePost);
        return "redirect:/posts";
    }
}