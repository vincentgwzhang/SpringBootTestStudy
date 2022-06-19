package com.boraji.tutorial.springboot.controller;

import com.boraji.tutorial.springboot.model.User;
import com.boraji.tutorial.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String getAllUsers(@ModelAttribute User user, Model model) {
        model.addAttribute("users", userRepository.searchBySortName());
        return "userlist";
    }

    @PostMapping("/add")
    public String addUser(@Validated @ModelAttribute User user, BindingResult result, Model model) {
        model.addAttribute("users", userRepository.searchBySortName());

        if (result.hasErrors())
            return "userlist";

        userRepository.save(user);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        return "useredit";
    }

    @PostMapping("/edit")
    public String updateUser(@Validated @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "useredit";
        }
        userRepository.save(user);
        return "redirect:/";
    }

}
