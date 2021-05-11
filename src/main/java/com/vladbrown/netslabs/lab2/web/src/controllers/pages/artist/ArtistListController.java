package com.vladbrown.netslabs.lab2.web.src.controllers.pages.artist;


import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;
import com.vladbrown.netslabs.lab2.core.service.ArtistService;
import com.vladbrown.netslabs.lab2.web.src.converters.ArtistConverter;
import com.vladbrown.netslabs.lab2.web.src.dto.ArtistData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/artists")
public class ArtistListController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistConverter artistConverter;

    @GetMapping
    public List<ArtistData> getArtists() {
        return artistConverter.convertAll(artistService.findAll());
    }

    @PostMapping
    public Artist postArtist(@RequestBody Artist artist) {
        return artistService.save(artist);
    }
}

