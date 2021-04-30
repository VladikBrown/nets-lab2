package com.vladbrown.netslabs.lab2.web.src.controllers.pages.track;

import com.vladbrown.netslabs.lab2.core.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("track")
public class TrackDetailsController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/{trackId}")
    public void addNewTrack(@PathVariable String trackId) {
        trackService.findById(Long.valueOf(trackId));
    }
}
