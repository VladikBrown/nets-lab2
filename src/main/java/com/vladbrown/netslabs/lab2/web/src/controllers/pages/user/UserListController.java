package com.vladbrown.netslabs.lab2.web.src.controllers.pages.user;

import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserListController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        List<User> users = userService.findAll();
        return users;
    }


    @PostMapping
    public User postUser(@RequestBody User user) {
        System.out.println(user);
        return userService.save(user);
    }
}
