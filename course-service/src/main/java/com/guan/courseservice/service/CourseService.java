package com.guan.courseservice.service;

import com.guan.courseservice.dao.CourseRepository;
import com.guan.courseservice.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:Guan
 * @date 2019/5/27,10:45
 **/
@Service
@Transactional
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public List<Course> findAll(){
        return courseRepository.findAll();
    }
    public Course findById(Long id){
        return courseRepository.findById(id).orElse(null);
    }
}
