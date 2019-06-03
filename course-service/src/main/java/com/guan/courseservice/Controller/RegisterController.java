package com.guan.courseservice.Controller;

import com.guan.courseservice.model.Email;
import com.guan.courseservice.model.User;
import com.guan.courseservice.service.EmailService;
import com.guan.courseservice.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:Guan
 * @date 2019/5/26,16:25
 **/
@RestController
public class RegisterController {

    @Resource
    UserService userService;
    @Resource
    EmailService emailService;
    @RequestMapping("/service/register")
    public User insert(String name,String password,String email,int code){
        Email email1 = emailService.findByEmail(email,code);
        if(email1 == null){
            return null;
        }
        else {
            User user = new User(name,password,email);
            System.out.println(name+password+email);
            return userService.insert(user);
        }

    }

}
