package com.database.controller;

import com.database.entity.User;
import com.database.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "User Api documentation")
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation(value = "New User adding method")
    @PostMapping("/addUser")
    public User addUser(@RequestBody User User) {
        return service.registerUser(User);
    }

   // @ApiOperation(value = "New User adding method")
    @PostMapping("/register")
    public User register(@RequestBody User User) {
        return service.registerUser(User);
    }



    //@ApiOperation(value = "New User adding method")
    @PostMapping("/login")
    public User login(Authentication authentication) {
        return service.loginUser(authentication);
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

    /*@ApiOperation(value = "Login the user by given name and password")
    @GetMapping("User/login/{name}/{password}")
    public User loginUser(@PathVariable String name , @PathVariable String password){return service.loginUser(name , password);}*/
}