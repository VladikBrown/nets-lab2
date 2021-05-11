package com.vladbrown.netslabs.lab2.web.src.controllers.pages.track;

import com.vladbrown.netslabs.lab2.core.domain.entity.Track;
import com.vladbrown.netslabs.lab2.core.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tracks")
public class TrackListController {

    @Autowired
    private TrackService trackService;

    @GetMapping
    public List<Track> getTracks() {
        return trackService.findAll();
    }
}
