package com.database.service;

import com.database.entity.User;
import com.database.repository.UserRepository;
import com.database.security.TokenManager;
import com.database.security.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import java.util.List;
/**
 * User service for user table
 */
@RequiredArgsConstructor
@Service
public class UserService {

    private final   PasswordEncoder passwordEncoder;
    private final AuthenticationProvider authenticationProvider;

    @Autowired
    private UserRepository repository;

    @Autowired
    TokenManager tokenManager;

    @Autowired
    UserDetailService userDetailService;


    /**
     *
     * @return all the users from user table
     */
    public List<User> getUsers() {
        return repository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public User getUserById(int id) {
        return repository.findById(id);
    }

    public User getUserByName(String name) {
        return repository.findByName(name);
    }

    public User getUserByEMail(String email) {
        return repository.findByEmail(email);
    }

    public ResponseEntity<String> deleteUser(int id) {

        try {

            repository.deleteById(id);
        }
        catch (Exception e){

            System.out.println("Deletion Failed");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Deletion Success");
        return new ResponseEntity(HttpStatus.OK);
    }


    public User registerUser(User user) {

        try{
            validateUserRegister(user);
        }
        catch (Exception e) {
            return null;
        }

        user.setRole("User");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return user;

    }




    public ResponseEntity<String> loginUser(User user){


        try {
            validateUserLogin(user);
            authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
            return ResponseEntity.ok(tokenManager.generateToken(user.getName()));

        }
        catch (Exception e){
            return   new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


    private void validateUserRegister(User user){

        Assert.notNull(user , "Null User");
        Assert.notNull(user.getName() , "Null User Name");
        Assert.notNull(user.getPassword() , "Null User Password");
        Assert.notNull(user.getEmail() , "Null User Email");
        Assert.isNull(getUserByName(user.getName()) , "User exists");
        Assert.isNull(getUserByEMail(user.getEmail()) , "Mail exists") ;

    }

    private void validateUserLogin(User user){
        Assert.notNull(user , "Null User");
        Assert.notNull(user.getName() , "Null User Name");
        Assert.notNull(user.getPassword() , "Null User Password");

    }


    public User updateUser(String userName , String password) {
        User existingUser = repository.findByName(userName);
        existingUser.setPassword(passwordEncoder.encode(password));
        return repository.save(existingUser);
    }
}
