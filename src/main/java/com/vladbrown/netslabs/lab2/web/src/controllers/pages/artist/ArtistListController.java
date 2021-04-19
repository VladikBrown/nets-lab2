package com.vladbrown.netslabs.lab2.web.src.controllers.pages.artist;


import com.vladbrown.netslabs.lab2.core.service.ArtistService;
import com.vladbrown.netslabs.lab2.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/artists")
public class ArtistListController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String getArtists(final Model model) {
        model.addAttribute("artists", artistService.findAll());
        model.addAttribute("users", userService.findAll());
        return "artistList";
    }
}

