package com.guan.courseclient.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author:Guan
 * @date 2019/5/27,9:51
 **/
@Component
public class Course {

    private Long id;


    private String name;

    private int number;

    private String time;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", time='" + time + '\'' +
                '}';
    }

    public Course(){

    }
    public Course(String name ,int people,String time){
        this.name = name;
        this.number = people;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number=number;
    }
}
