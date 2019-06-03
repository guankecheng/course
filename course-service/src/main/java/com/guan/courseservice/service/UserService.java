package com.guan.courseservice.service;

import com.guan.courseservice.dao.UserRepository;
import com.guan.courseservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:Guan
 * @date 2019/5/26,17:02
 **/
@Service
public class UserService {
    @Autowired
    UserRepository repository;
    public User insert(User user){
        return repository.save(user);
    }
    public User findByEmail(String email){
        return repository.findByEmail(email);
    }
}
