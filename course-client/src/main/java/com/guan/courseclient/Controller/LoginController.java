package com.guan.courseclient.Controller;

import com.guan.courseclient.interfaces.MyFeignClient;
import com.guan.courseclient.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author:Guan
 * @date 2019/5/24,18:16
 **/
@Controller
public class LoginController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    MyFeignClient myFeignClient;
    Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "/user/login")
    public String login(@RequestParam(value = "email") String email
            , @RequestParam(value = "password") String password
            , Map<String,Object> map
            , HttpSession session){
        logger.info("-guan-","begin");
        User user = myFeignClient.Login(email,password);
        logger.info("!guan!","end");
        if(user == null)
        {
            map.put("msg", "用户名或者密码错误");
            return "forward:/login";
        }
        else{
            session.setAttribute("loginUser",user);
            return "redirect:/user/findAll";
        }



    }

    @RequestMapping("/user/out")
    public String out(HttpSession session){
        session.setAttribute("loginUser",null);
        return "redirect:/login";

    }

}
