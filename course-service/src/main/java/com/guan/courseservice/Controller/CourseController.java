package com.guan.courseservice.Controller;


import com.guan.courseservice.model.Course;
import com.guan.courseservice.service.CourseService;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:Guan
 * @date 2019/5/27,10:47
 **/
@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @RequestMapping("/service/findAll")
    public List<Course> findAll(){
        return courseService.findAll();
    }
}
