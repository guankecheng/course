package com.guan.courseservice.dao;

import com.guan.courseservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends CrudRepository<User,Long> {
    public User findByEmailAndPassword(String email,String password);
    public User findByEmail(String email);

}
