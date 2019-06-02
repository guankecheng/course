package com.guan.courseclient.service;

import com.guan.courseclient.interfaces.MyFeignClient;
import com.guan.courseclient.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author:Guan
 * @date 2019/5/27,10:49
 **/
@Service
public class CourseService {
    @Autowired
    private MyFeignClient myFeignClient;
    public List<Course> findAll(){
          List<Course> list = myFeignClient.findAll();
        return list;
    }
}
