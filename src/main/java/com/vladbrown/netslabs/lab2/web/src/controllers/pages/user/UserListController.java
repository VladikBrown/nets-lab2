package com.vladbrown.netslabs.lab2.web.src.controllers.pages.user;

import com.vladbrown.netslabs.lab2.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserListController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(final Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }
}
