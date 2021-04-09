package com.vladbrown.netslabs.lab2.web.src.controllers;

import com.vladbrown.netslabs.lab2.core.domain.entity.User;
import com.vladbrown.netslabs.lab2.web.src.dto.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserDetailsController {

    @GetMapping("/{userId}")
    public String getUserInfo(@PathVariable String userId) {
        return "userDetails";
    }

    @GetMapping("/new")
    public String getUserForm() {
        return "userForm";
    }

    @PostMapping
    public String postUser(User user){
//        todo
        return "redirect:/user";
    }
}
