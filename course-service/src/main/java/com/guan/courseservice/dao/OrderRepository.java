package com.guan.courseservice.dao;

import com.guan.courseservice.model.Course;
import com.guan.courseservice.model.Courseorder;
import com.guan.courseservice.model.Courseorder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Courseorder,Long> {
    @Override
    public List<Courseorder> findAll();

    public List<Courseorder> findByUserIdAndCourseId(Long userId,Long courseId);

    public List<Courseorder> findAllByUserId(Long userId);
}
