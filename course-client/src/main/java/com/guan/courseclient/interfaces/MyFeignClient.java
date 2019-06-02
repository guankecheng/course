package com.guan.courseclient.interfaces;

import com.guan.courseclient.model.Course;
import com.guan.courseclient.model.Email;
import com.guan.courseclient.model.FeignClientFallbackFactory;
import com.guan.courseclient.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author:Guan
 * @date 2019/5/28,13:18
 **/
//@FeignClient(name = "course-service")
@FeignClient(name = "course-service",fallback = FeignClientFallbackFactory.class)
public interface MyFeignClient {
    @RequestMapping("/service/login")
    public User Login(@RequestParam("email") String email, @RequestParam("password") String password);

    @RequestMapping("/service/sendEmail")
    public Email sendEmail(@RequestParam("email") String email);

    @RequestMapping("/service/findAll")
    public List<Course> findAll();

    @RequestMapping("/service/choose")
    public String choose(@RequestParam("userId") Long userId,@RequestParam("courseId") Long courseId);

    @RequestMapping("/service/findCourse")
    List<Course> findCourse(@RequestParam("userId") Long userId);

    @RequestMapping("/service/remove")
    public String removeCourse(@RequestParam("userId") Long userId,@RequestParam("courseId") Long courseId);

    @RequestMapping("/service/register")
    public User insert(@RequestParam(value = "email") String email
            ,@RequestParam(value = "name") String name
            , @RequestParam(value = "password") String password
            , @RequestParam(value = "code") int code);



}
