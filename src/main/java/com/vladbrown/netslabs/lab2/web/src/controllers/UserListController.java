package com.vladbrown.netslabs.lab2.web.src.controllers;

import com.vladbrown.netslabs.lab2.core.service.UserService;
import com.vladbrown.netslabs.lab2.web.src.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/users")
@Controller
public class UserListController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());

        return "userList";
    }
}
