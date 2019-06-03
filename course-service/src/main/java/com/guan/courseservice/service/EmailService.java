package com.guan.courseservice.service;

import com.guan.courseservice.dao.EmailRepository;
import com.guan.courseservice.model.Email;
import com.guan.courseservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:Guan
 * @date 2019/5/26,17:21
 **/
@Service
@Transactional
public class EmailService {
    @Autowired
    EmailRepository repository;

    public Email insert(Email email){
        if(repository.findByEmail(email.getEmail()) == null)
        {
            return repository.save(email);
        }
        else{
            repository.updateEmail(email.getEmail(),email.getCode());
            return repository.findByEmail(email.getEmail());
        }

    }

    public Email findByEmail(String email,int code){
        return repository.findByEmailAndCode(email,code);
    }



}
