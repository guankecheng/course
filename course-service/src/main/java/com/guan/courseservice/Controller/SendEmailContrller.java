package com.guan.courseservice.Controller;

import com.guan.courseservice.dao.UserRepository;
import com.guan.courseservice.model.Email;
import com.guan.courseservice.model.User;
import com.guan.courseservice.service.EmailService;
import com.guan.courseservice.service.UserService;
import com.guan.courseservice.utils.CaptchaUtil;
import com.guan.courseservice.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:Guan
 * @date 2019/5/26,16:15
 **/
@RestController
public class SendEmailContrller {
    @Autowired
    UserService userService;
    @Autowired
    EmailService emailService;
    @Autowired
    EmailUtil emailUtil;
    @RequestMapping("/service/sendEmail")
    public Email sendEmail(@RequestParam("email")String email){
        System.out.println("!!!!!!!!!!!1111");

        if(userService.findByEmail(email) == null){


            int code = Integer.parseInt(CaptchaUtil.captcha(4));
            emailUtil.sendEmail(email,String.valueOf(code));
            Email email1 = emailService.insert(new Email(email,code));
            System.out.println(email1.toString());
            return email1;

        }
        else
            return null;

    }

    @RequestMapping("/service/sendTest")
    public String sendTest(){
        int code = Integer.parseInt(CaptchaUtil.captcha(4));
        emailUtil.sendEmail("939106926@qq.com",String.valueOf(code));
        return "okkk"+"email:939106926@qq.com"+",code:"+code;
    }

}
