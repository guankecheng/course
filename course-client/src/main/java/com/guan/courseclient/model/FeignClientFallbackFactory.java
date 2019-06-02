package com.guan.courseclient.model;


import com.guan.courseclient.interfaces.MyFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeignClientFallbackFactory implements MyFeignClient {
    private static final Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public User Login(String email, String password) {

        return null;
    }

    @Override
    public Email sendEmail(String email) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public String choose(Long userId, Long courseId) {
        return "选课失败";
    }

    @Override
    public List<Course> findCourse(Long userId) {
        return null;
    }

    @Override
    public String removeCourse(Long userId, Long courseId) {
        return "退课失败";
    }

    @Override
    public User insert(String email, String username, String password, int code) {
        return null;
    }

}
