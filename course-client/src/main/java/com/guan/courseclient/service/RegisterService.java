package com.guan.courseclient.service;

import com.guan.courseclient.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author:Guan
 * @date 2019/5/26,19:59
 **/
@Service
public class RegisterService {
    @Autowired
    private RestTemplate restTemplate;

    public User register(User user,int code)
    {

        User user1 = restTemplate.getForObject("http://course-service/service/register?email="+user.getEmail()+"&name="
                +user.getName()+"&password="+user.getPassword()+"&code="+code,User.class);

        return user1;

    }

}
