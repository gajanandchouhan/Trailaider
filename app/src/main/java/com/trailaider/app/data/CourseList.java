package com.trailaider.app.data;

import java.io.Serializable;

/**
 * Created by gajanand on 30/6/18.
 */

public class CourseList implements Serializable{
    private String title;
    private String desc;
    private String time;
    private String unit;
    private boolean completed;
    private String distance;
    private String speed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public boolean isCompleted() {
        return completed;
    }
}
