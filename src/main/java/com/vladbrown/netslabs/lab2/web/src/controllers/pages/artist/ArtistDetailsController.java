package com.vladbrown.netslabs.lab2.web.src.controllers.pages.artist;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;
import com.vladbrown.netslabs.lab2.core.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artist")
public class ArtistDetailsController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/{artistId}")
    public Artist getArtist(@PathVariable String artistId) {
        Artist artist = artistService.findById(Long.valueOf(artistId));
        return artist;
    }

    @PutMapping("/{artistId}")
    public Artist updateArtistInfo(@PathVariable String artistId, @RequestBody Artist artist) {
        artist.setId(Long.valueOf(artistId));
        Artist savedArtist = artistService.save(artist);
        return savedArtist;
    }

    @DeleteMapping("/{artistId}")
    public void deleteArtist(@PathVariable String artistId) {
        artistService.deleteById(Long.valueOf(artistId));
    }


    @PostMapping("/{artistId}/album")
    public Artist addNewAlbum(@PathVariable String artistId, @RequestBody Album album) {
        artistService.addNewAlbum(artistId, album);
        return artistService.findById(Long.valueOf(artistId));
    }
}
