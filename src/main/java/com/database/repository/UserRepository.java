package com.database.repository;

import com.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {

    User  findByName(String userName); ////Get user with given name information from user table
    User findById(int id); //Get user with given id information from user table
    User findByEmail(String email);
}