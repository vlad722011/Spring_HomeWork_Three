package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {
    @Autowired
    private RegistrationService registrationService;


    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService().getRepository().getUsers();
    }


    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        registrationService.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    @GetMapping("/param")
    public User userAddFromParam(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        return registrationService.processRegistration(name, age, email);
    }
}
