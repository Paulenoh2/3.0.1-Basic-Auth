package com.example.authen.service;

import com.example.authen.entities.User;

import java.util.List;
import java.util.Optional;

public interface Service {


    public String createUser(User user);

    public String updateUser(User user);
    public Optional<User> getUserById(Long id);
    public void deleteUserById(Long id);

    public List<User> getAllUsers();






}
