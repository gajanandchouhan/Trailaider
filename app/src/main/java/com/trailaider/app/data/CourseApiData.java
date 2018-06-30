package com.trailaider.app.data;

import java.util.List;

/**
 * Created by gajanand on 30/6/18.
 */

public class CourseApiData {
    private String course_id;
    private String gender;
    private String bmi_from;
    private String bmi_to;
    private String altitude_from;
    private String altitude_to;
    private String no_of_weeks;
    private List<CourseApiContent> course_content;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBmi_from() {
        return bmi_from;
    }

    public void setBmi_from(String bmi_from) {
        this.bmi_from = bmi_from;
    }

    public String getBmi_to() {
        return bmi_to;
    }

    public void setBmi_to(String bmi_to) {
        this.bmi_to = bmi_to;
    }

    public String getAltitude_from() {
        return altitude_from;
    }

    public void setAltitude_from(String altitude_from) {
        this.altitude_from = altitude_from;
    }

    public String getAltitude_to() {
        return altitude_to;
    }

    public void setAltitude_to(String altitude_to) {
        this.altitude_to = altitude_to;
    }

    public String getNo_of_weeks() {
        return no_of_weeks;
    }

    public void setNo_of_weeks(String no_of_weeks) {
        this.no_of_weeks = no_of_weeks;
    }

    public List<CourseApiContent> getCourse_content() {
        return course_content;
    }

    public void setCourse_content(List<CourseApiContent> course_content) {
        this.course_content = course_content;
    }
}
