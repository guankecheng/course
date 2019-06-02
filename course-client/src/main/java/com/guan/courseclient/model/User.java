package com.guan.courseclient.model;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author:Guan
 * @date 2019/5/25,15:03
 **/
@Component
public class User{

    private Long id;

    private String name;

    private String password;

    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public User(){

    }
    public User(String email,String name,String password){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
