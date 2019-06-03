package com.guan.courseservice.service;

import com.guan.courseservice.dao.CourseRepository;
import com.guan.courseservice.dao.OrderRepository;
import com.guan.courseservice.model.Course;
import com.guan.courseservice.model.Courseorder;
import com.guan.courseservice.model.Courseorder;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Guan
 * @date 2019/5/27,17:22
 **/
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CourseRepository courseRepository;
    public List<Courseorder> findAll(){
        return orderRepository.findAll();
    }

    public String insert(Courseorder order)
    {

        Course course = new Course();
        course =  courseRepository.findById(order.getCourseId()).orElse(null);
        if(course.getNumber() <= 0)
            return "课程已被选完";
        List<Courseorder> order1 = orderRepository.findByUserIdAndCourseId(order.getUserId(),order.getCourseId());
        if(order1.size()  != 0){
            return "你已选择此课程";
        }
        List<Courseorder> list = orderRepository.findAllByUserId(order.getUserId());
        for(Courseorder order2: list){
            Course course1 = courseRepository.findById(order2.getCourseId()).orElse(null);
            if(course1.getTime().equals(course.getTime()))
                return "你所选课程时间有冲突";
        }
        courseRepository.updateCourse(order.getCourseId()
            ,courseRepository.findById(order.getCourseId()).orElse(null).getNumber()-1);
        orderRepository.save(order);

        return "ok";
    }


    public List<Course> findCourses(Long userId){
        List<Courseorder> list = orderRepository.findAllByUserId(userId);
        List<Course> list1 = new ArrayList<Course>();
        for(Courseorder courseorder:list){
            list1.add(courseRepository.findById(courseorder.getCourseId()).orElse(null));
        }
        return list1;
    }

    public String removeCourse(Courseorder order){
        if(orderRepository.findByUserIdAndCourseId(order.getUserId(),order.getCourseId()).size() != 0)
        {
            courseRepository.updateCourse(order.getCourseId()
                    ,courseRepository.findById(order.getCourseId()).orElse(null).getNumber()+1);
            orderRepository.delete(orderRepository.findByUserIdAndCourseId(order.getUserId(),order.getCourseId()).get(0));
            return "退课成功";

        }
        else {
            return "退课失败，请重试";
        }




    }


}
