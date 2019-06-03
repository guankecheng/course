package com.guan.courseservice.dao;

import com.guan.courseservice.model.Email;
import com.guan.courseservice.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email,Long> {
    public Email findByEmail(String email);

    @Query(value = "update email set code=?2 where email=?1 ", nativeQuery = true)
    @Modifying
    public void updateEmail(String email,int code);

    public Email findByEmailAndCode(String email,int code);

}
