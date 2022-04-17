package com.database.service;

import com.database.entity.User;
import com.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    @Autowired
    private UserRepository repository;


    public List<User> saveUsers(List<User> Users) {

        return repository.saveAll(Users);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return repository.findByName(name);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "User removed !! " + id;
    }


    public User registerUser(User user) {
        if (getUserByName(user.getName()) == null){
            repository.save(user);
            return user;
        }
        else{
            return null;
        }
    }

    public User loginUser(String name , String password){

        User requestedUser = repository.findByName(name);
        if (requestedUser == null){
            return null;
        }
        else if(requestedUser.getPassword() != password){
            return null;
        }
        else{
            return requestedUser;
        }

    }


}
