package com.database.repository;

import com.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    User  findByName(String userName);
    User findById(int id);
}