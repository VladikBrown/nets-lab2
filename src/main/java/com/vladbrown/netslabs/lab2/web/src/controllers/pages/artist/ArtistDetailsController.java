package com.vladbrown.netslabs.lab2.web.src.controllers.pages.artist;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;
import com.vladbrown.netslabs.lab2.core.service.ArtistService;
import com.vladbrown.netslabs.lab2.web.src.converters.ArtistConverter;
import com.vladbrown.netslabs.lab2.web.src.dto.ArtistData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/artist")
public class ArtistDetailsController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistConverter artistConverter;

    @GetMapping("/{artistId}")
    public ArtistData getArtist(@PathVariable String artistId) {
        Artist artist = artistService.findById(Long.valueOf(artistId));
        return artistConverter.convert(artist);
    }

    @PutMapping("/{artistId}")
    public ArtistData updateArtistInfo(@PathVariable String artistId, @RequestBody Artist artist) {
        artist.setId(Long.valueOf(artistId));
        Artist savedArtist = artistService.save(artist);
        return artistConverter.convert(savedArtist);
    }

    @DeleteMapping("/{artistId}")
    public void deleteArtist(@PathVariable String artistId) {
        artistService.deleteById(Long.valueOf(artistId));
    }


    @PostMapping("/{artistId}/album")
    public ArtistData addNewAlbum(@PathVariable String artistId, @RequestBody Album album) {
        artistService.addNewAlbum(artistId, album);
        var artist =  artistService.findById(Long.valueOf(artistId));
        return artistConverter.convert(artist);
    }
}
