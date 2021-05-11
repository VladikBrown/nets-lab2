package com.vladbrown.netslabs.lab2.web.src.controllers.pages.user;

import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.core.service.AlbumService;
import com.vladbrown.netslabs.lab2.core.service.ArtistService;
import com.vladbrown.netslabs.lab2.core.service.TrackService;
import com.vladbrown.netslabs.lab2.core.service.UserService;
import com.vladbrown.netslabs.lab2.web.src.converters.UserConverter;
import com.vladbrown.netslabs.lab2.web.src.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
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

    @Autowired
    private UserConverter userConverter;

    @GetMapping("/{userId}")
    public UserData getUserInfo(@PathVariable String userId) {
        User user = userService.findById(Long.valueOf(userId));
        return userConverter.convert(user);
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
