package com.guan.courseclient;

import com.guan.courseclient.interfaces.MyFeignClient;
import com.guan.courseclient.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseClientApplicationTests {
@Autowired
    OrderService orderService;
@Autowired
    MyFeignClient myFeignClient;
    @Test
    public void contextLoads() {
        System.out.println(myFeignClient.choose(Long.valueOf(1),Long.valueOf(1)));;

    }

}
