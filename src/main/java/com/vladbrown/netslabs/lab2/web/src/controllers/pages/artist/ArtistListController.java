package com.vladbrown.netslabs.lab2.web.src.controllers.pages.artist;


import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;
import com.vladbrown.netslabs.lab2.core.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistListController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public List<Artist> getArtists() {
        return artistService.findAll();
    }

    @PostMapping
    public Artist postArtist(@RequestBody Artist artist) {
        return artistService.save(artist);
    }
}

