package com.guan.courseclient.Controller;

import com.guan.courseclient.interfaces.MyFeignClient;
import com.guan.courseclient.model.Email;
import com.guan.courseclient.model.User;
import com.guan.courseclient.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author:Guan
 * @date 2019/5/25,14:14
 **/
@Controller
public class RegisterController {
    @Autowired
    private MyFeignClient myFeignClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RegisterService registerService;
    @RequestMapping(value = "/user/sendEmail")
    public String sendEmail(@RequestParam(value = "email")String email, Map<String,Object> map){
            Email email1 = restTemplate.getForObject("http://course-service/service/sendEmail?email="+email,Email.class);

//        Email email1 = myFeignClient.send(email);


        if(email1 == null)
        {

            map.put("res", false);

            map.put("msg", "邮箱已被注册");
            return "forward:/register";
        }
        else{
            map.put("res", true);

            map.put("email",email1.getEmail());

            return "forward:/register";
        }
    }
    @RequestMapping("/user/register")
    public String register(@RequestParam(value = "email") String email
            ,@RequestParam(value = "username") String username
            , @RequestParam(value = "password1") String password
            , @RequestParam(value = "code") int code
            ,Map<String,Object> map){
        User user = myFeignClient.insert(email,username,password,code);
        System.out.println(email+username+password+code);
        if (user == null){
            map.put("msg","验证码错误,重新发送");
            return "forward:/register";

        }
        else {
            map.put("msg","注册成功");
            return "forward:/login";
        }
    }
}
