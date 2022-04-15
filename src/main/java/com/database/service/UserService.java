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

    public User saveUser(User user) {
        if (getUserByName(user.getName()) == null){
            repository.save(user);
            return user;
        }
        else{
            return null;
        }
    }

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


}
