package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Post;
import com.codeup.springblogapp.model.User;
import com.codeup.springblogapp.repositories.PostRepository;
import com.codeup.springblogapp.repositories.UserRepository;
import com.codeup.springblogapp.services.AdEmailService;
import com.codeup.springblogapp.services.PostEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private UserRepository userDao;
    private PostRepository postDao;
    private PostEmailService postEmailService;

    public PostController(UserRepository userDao, PostRepository postDao, PostEmailService postEmailService) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.postEmailService = postEmailService;
    }

    // View all posts
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String getPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    // View an individual post (by type)
    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String getIndividualPost(@PathVariable long id, Model model) {
        Post thisPost = postDao.getOne(id);
        model.addAttribute("post", thisPost);
        return "posts/show";
    }

    // View create post form
    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String viewPostForm() {
        return "posts/create";
    }

    // Submit create post form
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String submitCreatePost(@RequestParam String title, @RequestParam String body) {
        // before saving a post to db, assign a user to that post
        User author = userDao.getOne((long) 1); // manually create user id of 1 in a variable 'author'
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);
        newPost.setUser(author); // manually assign user id of 1 to this post
        postDao.save(newPost);
        postEmailService.prepareAndSend(newPost, "You created a post", "Title: \n" + newPost.getTitle() + "\n\n" + "Description: \n" + newPost.getBody());
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String getEditPostForm(@PathVariable long id, Model model){
        Post singlePost = postDao.getOne(id);
        model.addAttribute("post", singlePost);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String savePostEdit(@PathVariable long id, @RequestParam String title, @RequestParam String body, Model model){
        Post editPost = postDao.getOne(id);
        editPost.setTitle(title);
        editPost.setBody(body);
        postDao.save(editPost);
        postEmailService.prepareAndSend(editPost, "You edited a post", "Title: \n" + editPost.getTitle() + "\n\n" + "Description: \n" + editPost.getBody());
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String getDeletePostForm(@PathVariable long id, Model model){
        Post singlePost = postDao.getOne(id);
        model.addAttribute("post", singlePost);
        return "posts/delete";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        Post singlePost = postDao.getOne(id);
        postDao.delete(singlePost);
        postEmailService.prepareAndSend(singlePost, "You deleted a post", "Title: \n" + singlePost.getTitle() + "\n\n" + "Description: \n" + singlePost.getBody());
        return "redirect:/posts";
    }
}
