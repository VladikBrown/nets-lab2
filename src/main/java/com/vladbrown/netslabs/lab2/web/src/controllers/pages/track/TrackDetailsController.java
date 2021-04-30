package com.vladbrown.netslabs.lab2.web.src.controllers.pages.track;

import com.vladbrown.netslabs.lab2.core.domain.entity.Track;
import com.vladbrown.netslabs.lab2.core.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("track")
public class TrackDetailsController {

    @Autowired
    private TrackService trackService;

    @GetMapping("/{trackId}")
    public Track getTrack(@PathVariable String trackId) {
        return trackService.findById(Long.valueOf(trackId));
    }

    @PutMapping("/{trackId}")
    public void addNewTrack(@PathVariable String trackId, Track track) {
        track.setId(Long.valueOf(trackId));
        trackService.save(track);
    }

    @DeleteMapping("/{trackId}")
    public void addNewTrack(@PathVariable String trackId) {
        trackService.deleteById(Long.valueOf(trackId));
    }
}
