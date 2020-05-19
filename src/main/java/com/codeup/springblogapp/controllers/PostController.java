package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Ad;
import com.codeup.springblogapp.model.Post;
import com.codeup.springblogapp.model.User;
import com.codeup.springblogapp.repositories.PostRepository;
import com.codeup.springblogapp.repositories.UserRepository;
import com.codeup.springblogapp.services.PostEmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/posts")
    public String showPosts(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
        Post thisPost = postDao.getOne(id);
        model.addAttribute("post", thisPost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePostForm(Model model) {
        Post post = new Post();
        post.setUser(userDao.getOne((long) 1)); // Manually set to first user
        model.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public RedirectView createPost(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postDao.save(post);
        postEmailService.prepareAndSend(post, "You created a post", "Title: \n" + post.getTitle() + "\n\n" + "Description: \n" + post.getBody());
        return new RedirectView("/posts/");
    }

    @GetMapping("/posts/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj == null || !(obj instanceof UserDetails)) {
            return "redirect:/login";
        }
        User user = (User) obj;
        Post post = postDao.getOne(id);
        if (post.getUser().getId() != user.getId()) {
            return "redirect:/posts/" + post.getId();
        }
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPostWithId(@PathVariable long id, @ModelAttribute Post post){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj == null || !(obj instanceof UserDetails)) {
            return "redirect:/login";
        }
        User user = (User) obj;
        Post editPost = postDao.getOne(id);
        editPost.setId(id);
        editPost.setUser(user);
        editPost.setTitle(post.getTitle());
        editPost.setBody(post.getBody());
        postDao.save(editPost);
        postEmailService.prepareAndSend(editPost, "You edited a post", "Title: \n" + editPost.getTitle() + "\n\n" + "Description: \n" + editPost.getBody());
        return "redirect:/posts/";
    }

    @GetMapping("/posts/{id}/delete")
    public String getDeletePostForm(@PathVariable long id, Model model){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj == null || !(obj instanceof UserDetails)) {
            return "redirect:/login";
        }
        User user = (User) obj;
        Post singlePost = postDao.getOne(id);
        Post post = postDao.getOne(id);
        if (post.getUser().getId() != user.getId()) {
            return "redirect:/posts/" + post.getId();
        }
        model.addAttribute("post", singlePost);
        return "/posts/delete";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id, Model model) {
        Post singlePost = postDao.getOne(id);
        postDao.delete(singlePost);
        postEmailService.prepareAndSend(singlePost, "You deleted an ad", "Title: \n" + singlePost.getTitle() + "\n\n" + "Description: \n" + singlePost.getBody());
        return "redirect:/ads";
    }
}
