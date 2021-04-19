package com.vladbrown.netslabs.lab2.web.src.controllers.pages.artist;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;
import com.vladbrown.netslabs.lab2.core.service.ArtistService;
import com.vladbrown.netslabs.lab2.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artist")
public class ArtistDetailsController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private UserService userService;

    @GetMapping("/{artistId}")
    public String getArtistInfo(@PathVariable String artistId,
                                Model model) {

        model.addAttribute("users", userService.findAll());
        model.addAttribute("artist", artistService.findById(Long.valueOf(artistId)));
        return "artistDetails";
    }

    @PutMapping("/{artistId}")
    public String updateArtistInfo(@PathVariable String artistId, Artist artist, Model model) {
        artist.setId(Long.valueOf(artistId));
        var savedArtist = artistService.save(artist);
        model.addAttribute("artist", savedArtist);
        return "redirect:/artist/" + savedArtist.getId();
    }

    @DeleteMapping("/{artistId}")
    public String deleteArtist(@PathVariable String artistId, Model model) {
        artistService.deleteById(Long.valueOf(artistId));
        return "redirect:/artists";
    }

    @PostMapping("/new")
    public String postArtist(Artist artist) {
        var savedArtist = artistService.save(artist);
        return "redirect:/artist/" + savedArtist.getId();
    }

    @PostMapping("/{artistId}/addAlbum")
    public String addNewAlbum(@PathVariable String artistId, Album album) {
        artistService.addNewAlbum(artistId, album);
        return "redirect:/artists";
    }
}
