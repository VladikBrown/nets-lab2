package com.vladbrown.netslabs.lab2.web.src.controllers.pages.album;

import com.vladbrown.netslabs.lab2.core.domain.entity.Album;
import com.vladbrown.netslabs.lab2.core.domain.entity.Track;
import com.vladbrown.netslabs.lab2.core.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/album")
public class AlbumDetailsController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/{albumId}")
    public Album getAlbum(@PathVariable String albumId){
        return albumService.findById(Long.valueOf(albumId));
    }

    @PutMapping("/{albumId}")
    public void updateAlbum(@PathVariable String albumId, @RequestBody Album album){
        album.setId(Long.valueOf(albumId));
        albumService.save(album);
    }

    @DeleteMapping("/{albumId}")
    public void deleteAlbum(@PathVariable String albumId){
        albumService.deleteById(Long.valueOf(albumId));
    }

    @PostMapping("/{albumId}/track")
    public Album addNewTrack(@PathVariable String albumId, @RequestBody Track track) {
        albumService.addNewTrack(albumId, track);
        return albumService.findById(Long.valueOf(albumId));
    }
}
