package com;
import com.database.controller.UserController;
import com.database.entity.User;
import com.database.repository.UserRepository;
import com.database.security.TokenManager;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public  class UserServiceTest {

    @Autowired
    private com.database.controller.UserController userController;

    @InjectMocks
    private TokenManager tokenManager;

    @Autowired
    private UserRepository userRepository;



    @Test
    public void RegisterSuccessTest() {

        System.out.println(userController.register("Ali","Veli","UmudunutKaybetme"));


    }


    @Test
    public void LoginSuccessTest() {


        System.out.println(userController.login(new User("UserTest3","UserTest3"))) ;

    }


}

