package com.guan.courseservice.Controller;

import com.guan.courseservice.model.Course;
import com.guan.courseservice.model.Courseorder;
import com.guan.courseservice.model.Courseorder;
import com.guan.courseservice.service.CourseService;
import com.guan.courseservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:Guan
 * @date 2019/5/27,17:21
 **/
@RestController
public class ChooseController {
    @Autowired
    OrderService orderService;
    @Autowired
    CourseService courseService;
   @RequestMapping("/service/choose")
    public String choose(Long userId,Long courseId){
       Courseorder courseorder = new Courseorder(userId,courseId,courseService.findById(courseId).getTime());
//       System.out.println(courseService.findById(courseId).getTime());
       return orderService.insert(courseorder);
   }

   @RequestMapping("/service/findCourse")
    public List<Course> findCourse(Long userId){
       return orderService.findCourses(userId);
   }

   @RequestMapping("/service/remove")
    public String removeCourse(Long userId,Long courseId){
       Courseorder courseorder = new Courseorder(userId,courseId,courseService.findById(courseId).getTime());
       return orderService.removeCourse(courseorder);
   }
}
