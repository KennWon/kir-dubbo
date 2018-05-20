/*
package com.ken;

import com.ken.dto.UserReq;
import com.ken.model.Goods;
import com.ken.service.MongoCityService;
import com.ken.service.RedisService;
import com.ken.service.UserService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceApplication.class})
@ActiveProfiles("dev")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest 
{
    @Autowired
    private UserService userService;

    @Autowired
    private MongoCityService mongoCityService;

    @Autowired
    private RedisService redisService;

    @Test
    public void shouldAnswerWithTrue()
    {
        UserReq model=new UserReq();
        model.setName("wangkun");
        userService.insertInfo(model);

    }
    @Test
    public void insertMongodbCity(){
        Goods goods = new Goods();
        goods.setName("王坤");
        mongoCityService.insertInfo(goods);
    }

    @Test
    public void testRedis(){
        redisService.set("wangkun","123",60);
        System.out.println(redisService.get("wangkun"));
    }

}
*/
