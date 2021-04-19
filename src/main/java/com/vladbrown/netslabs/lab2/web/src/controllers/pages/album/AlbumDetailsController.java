package com.vladbrown.netslabs.lab2.web.src.controllers.pages.album;

import com.vladbrown.netslabs.lab2.core.domain.entity.Track;
import com.vladbrown.netslabs.lab2.core.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/album")
public class AlbumDetailsController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/{albumId}/addTrack")
    public String addNewTrack(@PathVariable String albumId, Track track, Model model) {
        System.out.println(albumId);
        albumService.addNewTrack(albumId, track);
        var artist = albumService.findById(Long.valueOf(albumId)).getArtist().getId();
        return "redirect:/artist/" + artist;
    }
}
