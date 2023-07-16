package com.example.authen.controller;


import com.example.authen.entities.User;
import com.example.authen.service.imple.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService service;




    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        service.createUser(user);
        System.out.println(user);
        return "User successfully created";
    }

    @PutMapping("/edit")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String update(User user) {
        service.updateUser(user);
        return "Update user was successfull";
    }


    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAthority('ROLE_ADMIN')")
    public String delete(@PathVariable Long id) {
        service.deleteUserById(id);
        return "Delete user by Id successfull";
    }


    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    List<User> getUsers() {
        List<User> users = service.getAllUsers();
        return users;
    }


    @GetMapping("/users/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    Optional<User> getById(@PathVariable Long id) {
        Optional<User> userById = service.getUserById(id);
        return userById;

    }


    @GetMapping("/welcome")
    public String messaage() {
        return "Welcome to none Authentication page";
    }



    }



