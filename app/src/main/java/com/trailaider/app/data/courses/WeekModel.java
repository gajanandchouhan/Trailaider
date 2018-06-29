package com.trailaider.app.data.courses;

import java.util.List;

/**
 * Created by gajanand on 31/3/18.
 */

public class WeekModel {
    private String week;
    private List<CourseDataModel> daysList;
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public List<CourseDataModel> getDaysList() {
        return daysList;
    }

    public void setDaysList(List<CourseDataModel> daysList) {
        this.daysList = daysList;
    }



}
