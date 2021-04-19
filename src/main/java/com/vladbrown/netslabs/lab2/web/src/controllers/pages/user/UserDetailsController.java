package com.vladbrown.netslabs.lab2.web.src.controllers.pages.user;

import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.core.service.AlbumService;
import com.vladbrown.netslabs.lab2.core.service.ArtistService;
import com.vladbrown.netslabs.lab2.core.service.TrackService;
import com.vladbrown.netslabs.lab2.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
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
    public String getUserInfo(@PathVariable String userId, Model model) {
        model.addAttribute("user", userService.findById(Long.valueOf(userId)));
        return "userDetails";
    }

    @PutMapping("/{userId}")
    public String updateUserInfo(@PathVariable String userId, User user, Model model) {
        user.setId(Long.valueOf(userId));
        var savedUser = userService.save(user);
        model.addAttribute("user", savedUser);
        return "redirect:/user/" + savedUser.getId();
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId, Model model) {
        userService.deleteById(Long.valueOf(userId));
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String getUserForm() {
        return "userForm";
    }

    @PostMapping("/likeArtist")
    public String likeArtist(String artistId, String username) {
        artistService.likeArtistByUsername(username, Long.valueOf(artistId));
        return "redirect:/artists";
    }

    @PostMapping("/likeAlbum")
    public String likeAlbum(String albumId, String username) {
        albumService.likeAlbumByUsername(username, Long.valueOf(albumId));
        return "redirect:/artist/" + albumService.findById(Long.valueOf(albumId)).getArtist().getId();
    }

    @PostMapping("/likeTrack")
    public String likeTrack(String trackId, String username) {
        trackService.likeTrackByUsername(username, Long.valueOf(trackId));
        return "redirect:/artist/" + trackService.findById(Long.valueOf(trackId)).getAlbum().getArtist().getId();
    }

    @PostMapping("/new")
    public String postUser(User user) {
        System.out.println(user);
        var savedUser = userService.save(user);
        return "redirect:/users";
    }
}
