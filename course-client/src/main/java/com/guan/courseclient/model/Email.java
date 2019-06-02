package com.guan.courseclient.model;

import org.springframework.stereotype.Component;

/**
 * @author:Guan
 * @date 2019/5/26,17:20
 **/
@Component
public class Email {

    private Long id;

    private String email;

    private int code;

    public  Email(){

    }
    public Email(String email,int code){
        this.email = email;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", code=" + code +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
