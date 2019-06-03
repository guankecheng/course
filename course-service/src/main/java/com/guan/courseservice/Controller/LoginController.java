package com.guan.courseservice.Controller;

import com.guan.courseservice.dao.UserRepository;
import com.guan.courseservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Guan
 * @date 2019/5/25,15:15
 **/
@RestController
public class LoginController {
    @Autowired
    private UserRepository reposiotry;
    @RequestMapping("/service/login")
    public User Login(String email,String password){
        return reposiotry.findByEmailAndPassword(email,password);
    }



}
