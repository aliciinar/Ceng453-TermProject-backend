package com.database;

import com.database.entity.User;
import com.database.repository.UserRepository;
import com.database.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public  class UserServiceTest {

    @InjectMocks
    private UserService userService;


    private UserRepository userRepository;

    @Before
    public  void  setUp(){
        userRepository = Mockito.mock(UserRepository.class);
    }

    @Test
    public   void RegisterSuccessTest(){

        /*User response;
        User test;

        System.out.println(">>>>>Task TestUserTable Started ");
        System.out.println("Adding Test User named UserTest with password UserTest and email saitsutss@gmail.com");
        test = new User("UserTest","UserTest","saitsutss@gmail.com");
        response = userService.registerUser(test);
        Mockito.when(userRepository.findByName(test.getName())).thenReturn(test);
        System.out.println(test.getName());
        System.out.println(response.getName());
        Assertions.assertEquals(test.getName(),response.getName());

        System.out.println("--------------");
        System.out.println("Adding Test User named  with same name with password UserTest2 and email saitsutss@gmail.com");

        User user2 = new User("UserTest","UserTest2","saitsutss@gmail.com");
        response = userService.registerUser(user2);
        Assertions.assertNull(test.getName(),response.getName());

        System.out.println("--------------");
        System.out.println("Adding Test User named UserTest with password UserTest2 and email saitsutss@gmail.com");


        test = new User("UserTest","","saitsutss@gmail.com");
        response =  userService.registerUser(test);
        Assertions.assertNull(response);

        test = new User("UserTest3","UserTest2","");
        response =  userService.registerUser(test);
        Assertions.assertNull(response);*/
        User response;
        User test;
        UserService userService = new UserService();
        test = new User("UserTest","UserTest","saitsutss@gmail.com");
        response = userService.registerUser(test);
        System.out.println(response.getName());
    }




}
