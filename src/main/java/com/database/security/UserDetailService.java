package com.database.security;


import com.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Optional;
import javax.sql.RowSet;
import java.util.ArrayList;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserDetailService  implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.database.entity.User  player = userRepository.findByName(username);
        if(player == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new User(player.getName(),player.getPassword(),new ArrayList<>());

    }


    private UserDetails toUserDetails(com.database.entity.User  user) {
        /* withDefaultPasswordEncoder hashes the password, creates authority list and returns a valid User */
        System.out.println("User dön bana");
        return User.withUsername(user.getName())
                .username(user.getName())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }


}
