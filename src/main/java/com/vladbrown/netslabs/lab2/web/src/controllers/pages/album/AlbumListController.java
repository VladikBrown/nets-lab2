package com.vladbrown.netslabs.lab2.web.src.controllers.pages.album;


import com.vladbrown.netslabs.lab2.core.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumListController {

    @Autowired
    private AlbumService albumService;

    @GetMapping()
    public void getAlbums() {
        albumService.findAll();
    }
}
