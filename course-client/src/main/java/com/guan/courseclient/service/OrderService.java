package com.guan.courseclient.service;

import com.guan.courseclient.interfaces.MyFeignClient;
import com.guan.courseclient.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author:Guan
 * @date 2019/5/27,19:00
 **/
@Service
public class OrderService {
    @Autowired
    private MyFeignClient myFeignClient;

    public String choose(Long userId,Long courseId){
        return myFeignClient.choose(userId,courseId);
    }

    public List<Course> findCourse(Long userId){
        return myFeignClient.findCourse(userId);
    }

    public String remove(Long userId,Long courseId){
        return myFeignClient.removeCourse(userId,courseId);
    }
}
