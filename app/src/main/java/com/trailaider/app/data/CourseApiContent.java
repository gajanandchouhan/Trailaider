package com.trailaider.app.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gajanand on 30/6/18.
 */

public class CourseApiContent  implements Serializable{
    private List<CourseAPiDays> days;

    public void setDays(List<CourseAPiDays> days) {
        this.days = days;
    }

    public List<CourseAPiDays> getDays() {
        return days;
    }
}
