package com.guan.courseservice;

import com.guan.courseservice.dao.CourseRepository;
import com.guan.courseservice.dao.OrderRepository;
import com.guan.courseservice.dao.UserRepository;
import com.guan.courseservice.model.Course;
import com.guan.courseservice.model.Email;
import com.guan.courseservice.model.Courseorder;
import com.guan.courseservice.model.User;
import com.guan.courseservice.service.EmailService;
import com.guan.courseservice.service.OrderService;
import com.guan.courseservice.service.UserService;
import com.guan.courseservice.utils.CaptchaUtil;
import com.guan.courseservice.utils.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceApplicationTests {
    @Autowired
    private OrderRepository reposiotry;

    @Autowired
            private CourseRepository courseRepository;
    Logger log = LoggerFactory.getLogger(CourseServiceApplication.class);
    @Autowired
    EmailService emailService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Test
    public void contextLoads() {
//        EmailUtil.sendMessage("939106926@qq.com",CaptchaUtil.captcha(4));
//        System.out.println(CaptchaUtil.captcha(4));

//        userService.insert(new User("zhao","aq114477","939@qq.com"));
//        User  user = new User("zhao","aq114477","939@qq.com");
//
//        reposiotry.save(user);
//        emailService.insert(new Email("93910626@qq.com",8888));
//        emailService.insert(new Email("93910626@qq.com",7777));
//        if(emailService.findByEmail("939106926@qq.com",4159) == null)
//        {
//            System.out.println("null");
//        }
//        else
//        System.out.println(emailService.findByEmail("939106926@qq.com",4159).getCode());


//        courseRepository.findById(new Long(1)).orElse(null);
//        System.out.println(course.getName());
//        for(Course course:courseRepository.findAll()){
//            System.out.println(course.getTime());
//        }
//       System.out.println(reposiotry.findByUserIdAndCourseId(Long.valueOf(1),Long.valueOf(2)).get(0).toString());
//       System.out.println(orderService.insert(new Courseorder(Long.valueOf(1),Long.valueOf(2),courseRepository.findById(Long.valueOf(1)).orElse(null).getTime())));
//        if(reposiotry.findByUserIdAndCourseId(Long.valueOf(1),Long.valueOf(2)).size() == 0)
//            System.out.println("null");
//        else
//            System.out.println("not null");
//        courseRepository.updateCourse(Long.valueOf(3),38);
//        Courseorder courseorder = new Courseorder(Long.valueOf(14),Long.valueOf(1),"星期四9-11节");
//        reposiotry.save(courseorder);
//        reposiotry.delete(new Courseorder(Long.valueOf(1),Long.valueOf(2),"星期三9-11节"));
//        System.out.println(  orderService.removeCourse(new Courseorder(Long.valueOf(1),Long.valueOf(2),"星期三9-11节")));

    }

}
