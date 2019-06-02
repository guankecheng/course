package com.guan.courseclient.Controller;

import com.guan.courseclient.model.Course;
import com.guan.courseclient.model.User;
import com.guan.courseclient.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:Guan
 * @date 2019/5/27,18:56
 **/
@Controller
public class ChooseController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/user/choose")
    public String choose( @RequestParam(value = "userId") Long userId,@RequestParam(value = "courseId")Long courseId,HttpSession session, Model model){
        String msg = orderService.choose(userId,courseId);
        System.out.println(msg);
        model.addAttribute("msg",msg);


        return "forward:/user/findAll";

    }

    @RequestMapping("/user/selection")
    public String findCourse(@RequestParam(value = "userId") Long userId,HttpSession session, Model model){
        List<Course> list = orderService.findCourse(userId);
        model.addAttribute("courses",list);
        session.setAttribute("user",session.getAttribute("loginUser"));
        model.addAttribute("user",session.getAttribute("loginUser"));
        return "forward:/myCourse";
    }

    @RequestMapping("user/remove")
    public String removeCourse(@RequestParam(value = "userId") Long userId,@RequestParam(value = "courseId")Long courseId,HttpSession session, Model model){
        String msg = orderService.remove(userId,courseId);

        model.addAttribute("msg",msg);
        session.setAttribute("user",session.getAttribute("loginUser"));
        model.addAttribute("user",session.getAttribute("loginUser"));
        return "forward:/user/selection";
    }
}
