package com.database.service;

import com.database.entity.User;
import com.database.repository.UserRepository;
import com.database.security.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.util.Assert;


import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService  {
    /**
     *
     */

    private final   PasswordEncoder passwordEncoder;
    private final AuthenticationProvider authenticationProvider;

    @Autowired
    private UserRepository repository;

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

    public String deleteUser(int id) {

        try {
            repository.deleteById(id);
        }
        catch (Exception e){
            System.out.println("Deletion Failed");
            return "User not removed";
        }
        System.out.println("Deletion Success");
        return "User removed !! " + id;
    }


    public User registerUser(User user) {

        try{
            validateUserLogin(user);
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("User " + user.getName() + " could not be added");
            return null;
        }

        user.setRole("User");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        System.out.println("User " + user.getName() + " added");
        return user;

    }


    public User loginUser(Authentication authentication){
        System.out.println("login deneme");
       User user = (User) authentication.getPrincipal();
       // Authentication authentication = new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword());
       // Authentication authenticatePlayer =authenticationProvider.authenticate(authentication);
       User requestedUser = repository.findByName(user.getName());
        System.out.println("bulundu");

        if (requestedUser == null){
            return null;
        }
        else{

            return  requestedUser;
        }

    }

    private void validateUserLogin(User user){

        Assert.notNull(user , "Null User");
        Assert.notNull(user.getName() , "Null User Name");
        Assert.notNull(user.getPassword() , "Null User Password");
        Assert.notNull(user.getEmail() , "Null User Email");
        Assert.isNull(getUserByName(user.getName()) , "User exists");

    }

    private void validateUserRegister(User user , String password){
        Assert.notNull(user , "Wrong Password or User Name");
        Assert.isTrue(user.getPassword() == password , "Wrong Password or User Name") ;
        Assert.isTrue(user.isVerified() , "User is Not Verified");
    }


}
