package com.vladbrown.netslabs.lab2.web.src.controllers.pages.user;

import com.vladbrown.netslabs.lab2.core.domain.entity.Artist;
import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.core.service.UserService;
import com.vladbrown.netslabs.lab2.web.src.converters.UserConverter;
import com.vladbrown.netslabs.lab2.web.src.dto.AlbumData;
import com.vladbrown.netslabs.lab2.web.src.dto.ArtistData;
import com.vladbrown.netslabs.lab2.web.src.dto.TrackData;
import com.vladbrown.netslabs.lab2.web.src.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
@RestController
public class UserListController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping
    public List<UserData> getUsers() {
        List<User> users = userService.findAll();
        return userConverter.convertAll(users);
    }

    @PostMapping
    public User postUser(@RequestBody User user) {
        return userService.save(user);
    }
}
