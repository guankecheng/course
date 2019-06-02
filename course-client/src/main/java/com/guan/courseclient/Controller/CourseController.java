package com.guan.courseclient.Controller;


import com.guan.courseclient.model.Course;
import com.guan.courseclient.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author:Guan
 * @date 2019/5/27,9:50
 **/
@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @RequestMapping("/user/findAll")
    public String findAll(HttpSession session, Model model){
        List<Course> list = courseService.findAll();
//        for (Course course:list){
//            System.out.println(course.toString());
//        }
        model.addAttribute("courses",list);
//        map.put("courses",list);
//        session.setAttribute("courses",list);
        session.setAttribute("user",session.getAttribute("loginUser"));
        model.addAttribute("user",session.getAttribute("loginUser"));

        return "forward:/main";
    }
}
