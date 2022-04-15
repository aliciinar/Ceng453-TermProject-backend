package com.database.controller;

import com.database.entity.User;
import com.database.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User User) {
        return service.saveUser(User);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> Users) {
        return service.saveUsers(Users);
    }

    @GetMapping("/Users")
    public List<User> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/UserById/{id}")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @GetMapping("/User/{name}")
    public User findUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    @DeleteMapping("User/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}