package com.database.controller;

import com.database.entity.User;
import com.database.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "User table controller documentation")
public class UserController {

    @Autowired
    private UserService service; // User service for controller


    @ApiOperation(value = "Registering new User method")
    @PostMapping("/register")
    public User register(@RequestBody String name , @RequestBody String password , @RequestBody String email) {

        return service.registerUser(name , password , email);
    }



    /**
     * Delete user who has the given id.
     * @param id id of the desired entity
     * @return
     */
    @ApiOperation(value = "Deleting the user with given id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }

    /**
     * Attempt to Login given user
     * @param user user information of the user
     * @return
     */
    @ApiOperation(value = "Login method")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return service.loginUser(user);
    }

    /**
     *
     * @return all the users from user table
     */
    @ApiOperation(value = "Getting all the users method")
    @GetMapping("/Users")
    public List<User> findAllUsers() {
        return service.getUsers();
    }


    /**
     *  Return user with the given id.
     * @param id id of the desiret user.
     * @return
     */
    @ApiOperation(value = "Getting the user by given ID")
    @GetMapping("/UserById/{id}")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    /**
     *  Return user with the given name.
     * @param name name of the desired user.
     * @return
     */
    @ApiOperation(value = "Getting the user by given name")
    @GetMapping("/User/{name}")
    public User findUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    /**
     * Updates user password.
     * @param userName name of the user
     * @param newPassword new password of the user
     * @return
     */
    @ApiOperation(value = "Update method to reset password")
    @PutMapping("/update")
    public User updateUser( @RequestBody String userName , @RequestBody String newPassword) {
        return service.updateUser(userName , newPassword);
    }
}