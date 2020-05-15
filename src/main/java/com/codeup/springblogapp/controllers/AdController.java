package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Ad;
import com.codeup.springblogapp.repositories.AdRepository;
import com.codeup.springblogapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
class AdController {

    private UserRepository userDao;
    private AdRepository adDao;

    public AdController(UserRepository userDao, AdRepository adDao) {
        this.userDao = userDao;
        this.adDao = adDao;
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
        adDao.save(ad);
        return new RedirectView("/ads/");
    }

    @GetMapping("/ads/{id}/edit")
    public String getEditAdForm(@PathVariable long id, Model model){
        Ad singleAd = adDao.getOne(id);
        model.addAttribute("ad", singleAd);
        return "ads/edit";
    }

    @PostMapping("/ads/{id}/edit")
    public String saveAdEdit(@PathVariable long id, @RequestParam String title, @RequestParam String description, Model model){
        Ad editAd = adDao.getOne(id);
        editAd.setTitle(title);
        editAd.setDescription(description);
        adDao.save(editAd);
        return "redirect:/ads";
    }

    @GetMapping("/ads/{id}/delete")
    public String getDeleteAdForm(@PathVariable long id, Model model){
        Ad singleAd = adDao.getOne(id);
        model.addAttribute("ad", singleAd);
        return "ads/delete";
    }

    @PostMapping("/ads/{id}/delete")
    public String deleteAd(@PathVariable long id){
        Ad singleAd = adDao.getOne(id);
        adDao.delete(singleAd);
        return "redirect:/ads";
    }
}
