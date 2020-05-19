package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Ad;
import com.codeup.springblogapp.model.User;
import com.codeup.springblogapp.repositories.AdRepository;
import com.codeup.springblogapp.repositories.UserRepository;
import com.codeup.springblogapp.services.AdEmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
class AdController {

    private UserRepository userDao;
    private AdRepository adDao;
    private AdEmailService adEmailService;

    public AdController(UserRepository userDao, AdRepository adDao, AdEmailService adEmailService) {
        this.userDao = userDao;
        this.adDao = adDao;
        this.adEmailService = adEmailService;
    }

    @GetMapping("/ads")
    public String showAds(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String showAd(@PathVariable long id, Model model) {
        Ad ad = adDao.getOne(id);
        model.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("/ads/create")
    public String gotoCreateAdForm(Model model) {
        Ad ad = new Ad();
        ad.setUser(userDao.getOne((long) 1)); // Manually set to first user
        model.addAttribute("ad", ad);
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public RedirectView createAd(@ModelAttribute Ad ad){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ad.setUser(user);
        adDao.save(ad);
        adEmailService.prepareAndSend(ad, "You created an ad", "Title: \n" + ad.getTitle() + "\n\n" + "Description: \n" + ad.getDescription());
        return new RedirectView("/ads/");
    }

    @GetMapping("/ads/{id}/edit")
    public String editAdForm(@PathVariable long id, Model model) {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj == null || !(obj instanceof UserDetails)) {
            return "redirect:/login";
        }
        User user = (User) obj;
        Ad ad = adDao.getOne(id);
        if (ad.getUser().getId() != user.getId()) {
            return "redirect:/ads/" + ad.getId();
        }
        model.addAttribute("ad", ad);
        return "/ads/edit";
    }

    @PostMapping("/ads/{id}/edit")
    public String editAdWithId(@PathVariable long id, @ModelAttribute Ad ad) {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj == null || !(obj instanceof UserDetails)) {
            return "redirect:/login";
        }
        User user = (User) obj;
        Ad editAd = adDao.getOne(id);
        editAd.setId(id);
        editAd.setUser(user);
        editAd.setTitle(ad.getTitle());
        editAd.setDescription(ad.getDescription());
        adDao.save(editAd);
        adEmailService.prepareAndSend(editAd, "You edited an ad", "Title: \n" + editAd.getTitle() + "\n\n" + "Description: \n" + editAd.getDescription());
        return "redirect:/ads/";
    }

    @GetMapping("/ads/{id}/delete")
    public String getDeleteAdForm(@PathVariable long id, Model model){

        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj == null || !(obj instanceof UserDetails)) {
            return "redirect:/login";
        }
        User user = (User) obj;
        Ad singleAd = adDao.getOne(id);
        Ad ad = adDao.getOne(id);
        if (ad.getUser().getId() != user.getId()) {
            return "redirect:/ads/" + ad.getId();
        }
        model.addAttribute("ad", singleAd);
        return "/ads/delete";
    }

    @PostMapping("/ads/{id}/delete")
    public String deleteAd(@PathVariable long id, Model model) {
        Ad singleAd = adDao.getOne(id);
        adDao.delete(singleAd);
        adEmailService.prepareAndSend(singleAd, "You deleted an ad", "Title: \n" + singleAd.getTitle() + "\n\n" + "Description: \n" + singleAd.getDescription());
        return "redirect:/ads";
    }
}
