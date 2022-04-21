package com;
import com.database.controller.UserController;
import com.database.entity.User;
import com.database.repository.ScoreWeekRepository;
import com.database.repository.UserRepository;
import com.database.security.TokenManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;



@RunWith(SpringRunner.class)
@SpringBootTest
public  class UserControllerTest {

    @Autowired
    private com.database.controller.UserController userController;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreWeekRepository scoreWeekRepository;

    /**
     *  Tests for  Registration API.Three type of cases are tested which are successful registration; null values of username, password and email ; adding existing user.
     */
    @Test
    public void RegisterSuccessTest() {

        Assertions.assertEquals(userController.register("TemporaryUser","TemporaryUserPass","TemporaryUserPass@gmail.com").getName(),"TemporaryUser");

        Assertions.assertNull(userController.register("TemporaryUser2",null,"TemporaryUserPass@gmail.com"));

        Assertions.assertNull(userController.register(null,null,"TemporaryUserPass@gmail.com"));

        Assertions.assertNull(userController.register(null,"TemporaryUserPass","TemporaryUserPass@gmail.com"));

        Assertions.assertNull(userController.register("TemporaryUser3","TemporaryUserPass",null));

        Assertions.assertNull(userController.register("TemporaryUser","TemporaryUserPass","TemporaryUserPass@gmail.com"));

        userController.deleteUser(userController.findUserByName("TemporaryUser").getId()); // This function is for deleting added user from database.
    }


    /**
     *  Tests for login.Three type of cases are tested which are successful login;  null values of username and password; trying login with non - existing user
     */
    @Test
    public void LoginSuccessTest() {

        User user1 = new User("UserTest3","UserTest3");
        User user2 = new User("10","UserTest10");
        User user3 = new User(null,"UserTest10");
        User user4 = new User("UserTest3",null);

        Assertions.assertEquals(userController.login(user1).getStatusCode(), HttpStatus.OK);

        Assertions.assertEquals(userController.login(user2).getStatusCode(), HttpStatus.BAD_REQUEST);

        Assertions.assertEquals(userController.login(user3).getStatusCode(), HttpStatus.BAD_REQUEST);

        Assertions.assertEquals(userController.login(user4).getStatusCode(), HttpStatus.BAD_REQUEST);

        userController.deleteUser(user1.getId());
        userController.deleteUser(user2.getId());
        userController.deleteUser(user3.getId());
        userController.deleteUser(user4.getId());




    }

    @Test
    public  void UserUpdateTest(){


        User user = userController.findUserByName("UserTest");
        String oldPassword = user.getPassword();
        userController.updateUser(user.getName() , "NewPassword");
        Assertions.assertNotEquals("Password Update Error",oldPassword , user.getPassword());
        userController.updateUser(user.getName() , "UserTest3");
    }





    /**
     * Tests for Deletion of existing user.One type of case is tested which is deletion of existing user successfully
     */

    @Test
    public  void  DeletePlayerSuccessTest(){

        User userTest = new User("UserTest4","UserTest4Password", "UserTest4@mail.com");

        userController.register(userTest.getName(),userTest.getPassword(),userTest.getEmail());

        userController.deleteUser(userController.findUserByName("UserTest4").getId());

        Assertions.assertNull(userController.findUserByName("UserTest4"));



    }


}

