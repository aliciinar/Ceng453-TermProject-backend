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


import java.util.List;
@RequiredArgsConstructor
@Service
public class UserService  {


    private final   PasswordEncoder passwordEncoder;
    private final AuthenticationProvider authenticationProvider;

    @Autowired
    private UserRepository repository;

    @Autowired
    UserDetailService userDetailService;


    public List<User> saveUsers(List<User> Users) {

        return repository.saveAll(Users);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        //return repository.findById(id).orElse(null);
        return repository.findById(id);
    }

    public User getUserByName(String name) {
        return repository.findByName(name);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "User removed !! " + id;
    }


    public User registerUser(User user) {
        if(ValidateUser(user)){
            user.setRole("User");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
            return  user;
        }
        else{
            return null;
        }
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

    private Boolean ValidateUser(User user){
        StringBuilder result = new StringBuilder();
         if(user == null){

             return false;
         }
         else{
             if(user.getName() == null){
                 return false;
             }
             else if( user.getPassword() == null){
                 return  false;
             }
             else if( user.getEmail() == null){
                 return  false;
             }

         }
         return true;
    }


}
