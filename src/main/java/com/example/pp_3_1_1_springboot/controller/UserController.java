package com.example.pp_3_1_1_springboot.controller;

import com.example.pp_3_1_1_springboot.model.User;
import com.example.pp_3_1_1_springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        userService.update(new User(name, email));
        return "redirect:/";
    }

    @PostMapping("/update")
    public String editUser(@RequestParam Long id,
                           @RequestParam String name,
                           @RequestParam String email) {
        userService.update(new User(id, name, email));
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}

