package com.guan.courseservice.dao;

import com.guan.courseservice.model.Course;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:Guan
 * @date 2019/5/27,10:05
 **/
@Transactional
public interface CourseRepository extends CrudRepository<Course,Long> {
    @Override
    public List<Course> findAll();



    @Query(value = "update course set number = ?2 where id = ?1", nativeQuery = true)
    @Modifying
    public void updateCourse(Long id ,int number);
//    public Course findById(Long id);


}
