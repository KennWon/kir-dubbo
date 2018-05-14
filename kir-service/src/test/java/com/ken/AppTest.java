package com.ken;

import com.ken.dto.UserReq;
import com.ken.service.UserService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceApplication.class})
@ActiveProfiles("dev")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest 
{
    @Autowired
    private UserService userService;



    @Test
    public void shouldAnswerWithTrue()
    {
        UserReq model=new UserReq();
        model.setName("wangkun");
        userService.insertInfo(model);

    }
}