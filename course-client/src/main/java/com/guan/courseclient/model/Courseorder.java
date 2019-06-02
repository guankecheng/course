package com.guan.courseclient.model;

/**
 * @author:Guan
 * @date 2019/5/27,19:40
 **/
public class Courseorder {

    private Long id;


    private Long userId;

    private Long courseId;


    private String time;

    public Courseorder(){

    }
    public Courseorder(Long userId,Long courseId,String time){
        this.userId = userId;
        this.courseId = courseId;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", time='" + time + '\'' +
                '}';
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
