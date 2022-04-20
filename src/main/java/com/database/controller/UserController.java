package com.database.controller;

import com.database.entity.User;
import com.database.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "User Api documentation")
public class UserController {

    @Autowired
    private UserService service;


   // @ApiOperation(value = "New User adding method")
    @PostMapping("/register")
    public User register(@RequestBody User User) {
        return service.registerUser(User);
    }

    @ApiOperation(value = "Deleting the user with given id")
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }

    //@ApiOperation(value = "New User adding method")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return service.loginUser(user);
    }

    @ApiOperation(value = "Getting all the users method")
    @GetMapping("/Users")
    public List<User> findAllUsers() {
        return service.getUsers();
    }



    @ApiOperation(value = "Getting the user by given ID")
    @GetMapping("/UserById/{id}")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @ApiOperation(value = "Getting the user by given name")
    @GetMapping("/User/{name}")
    public User findUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    @PutMapping("/update")
    public User updateUser( @RequestBody String userName , @RequestBody String newPassword) {
        return service.updateUser(userName , newPassword);
    }
}