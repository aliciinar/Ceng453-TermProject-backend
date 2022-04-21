package com;


import com.database.entity.ScoreMonth;
import com.database.entity.User;
import com.database.repository.ScoreMonthRepository;
import com.database.repository.UserRepository;
import com.database.service.ScoreMonthService;
import com.database.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreMonthServiceTest {


    @InjectMocks
    private ScoreMonthService scoreMonthService;

    @MockBean
    private ScoreMonthRepository scoreMonthRepository;

    @Before
    public void setUp() {
        scoreMonthRepository = Mockito.mock(ScoreMonthRepository.class);
        scoreMonthService = Mockito.mock(ScoreMonthService.class);
    }

    @Test
    public  void  saveScoreTest(){
        ScoreMonth scoreMonth = new ScoreMonth(50);
        User user = new User("UserTest", "UserTester", "saitsutss@gmail.com");
        when(scoreMonthService.saveScore(scoreMonth,user)).thenReturn(scoreMonth);
        Assertions.assertEquals(scoreMonth,scoreMonthService.saveScore(scoreMonth,user));


    }



}
