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

    public User saveUser(User User) {
        return repository.save(User);
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

    public User updateUser(User User) {
        User existingUser = repository.findById(User.getId()).orElse(null);
        existingUser.setName(User.getName());
        existingUser.setPassword(User.getPassword());
        return repository.save(existingUser);
    }
}
