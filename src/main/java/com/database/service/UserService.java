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
        System.out.println("serviceController");
        /*repository.save(user);
        return user;*/

        if(repository.findByName(user.getName()) == null ){
            if (ValidateUser(user)){
                repository.save(user);
                return user;
            }
            else{
                return null;
            }
        }
        return  null;

    }

    public List<User> saveUsers(List<User> Users) {

        return repository.saveAll(Users);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.findById(id);
    }

    public User getUserByName(String name) {
        return repository.findByName(name);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "User removed !! " + id;
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


    private  boolean ValidateUser(User user){
        System.out.println("Validate");
        if(user.getName() == null || user.getPassword() == null){
            return  false;
        }
        return  true;
    }


}
