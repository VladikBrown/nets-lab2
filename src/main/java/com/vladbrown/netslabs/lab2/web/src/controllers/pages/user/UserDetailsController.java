package com.vladbrown.netslabs.lab2.web.src.controllers.pages.user;

import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.core.service.AlbumService;
import com.vladbrown.netslabs.lab2.core.service.ArtistService;
import com.vladbrown.netslabs.lab2.core.service.TrackService;
import com.vladbrown.netslabs.lab2.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserDetailsController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private TrackService trackService;

    @GetMapping("/{userId}")
    public User getUserInfo(@PathVariable String userId) {
        User user = userService.findById(Long.valueOf(userId));
        return user;
    }

    @PutMapping("/{userId}")
    public void updateUserInfo(@PathVariable String userId, User user) {
        user.setId(Long.valueOf(userId));
        userService.save(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteById(Long.valueOf(userId));
    }

    @PutMapping("/{userId}/artis/{artistId}")
    public void likeArtist(@PathVariable String userId, @PathVariable String artistId) {
        artistService.likeArtistByUserId(Long.valueOf(userId), Long.valueOf(artistId));
    }

    @PutMapping("/{userId}/album/{albumId}")
    public void likeAlbum(@PathVariable String userId, @PathVariable String albumId) {
        albumService.likeAlbumByUserId(Long.valueOf(userId), Long.valueOf(albumId));
    }

    @PutMapping("/{userId}/track/{trackId}")
    public void likeTrack(@PathVariable String userId, @PathVariable String trackId) {
        trackService.likeTrackByUserId(Long.valueOf(userId), Long.valueOf(trackId));
    }

}
