package com;
import com.database.entity.User;
import com.database.repository.UserRepository;
import com.database.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public  class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = Mockito.mock(UserService.class);
    }

    @Test
    public void RegisterSuccessTest() {

        User response;
        User user = new User("UserTest", "UserTester", "saitsutss@gmail.com");
        when(userService.registerUser(user)).thenReturn(user);
        response = userService.registerUser(user);
        Assertions.assertEquals(user.getName(), response.getName());
        User user2 = new User(null, "UserTest2", "saitsutss@gmail.com");
        when(userService.registerUser(user)).thenReturn(user2);
        response = userService.registerUser(user);
        Assertions.assertNull(response.getName());

    }


    @Test
    public void LoginSuccessTest() {
        User user = new User("UserTest", "UserTester", "saitsutss@gmail.com");

        when(userService.loginUser(user)).then(returnsFirstArg());
        ;

        Assertions.assertNotNull(userService.loginUser(user));
    }
}

