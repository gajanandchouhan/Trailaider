package com.trailaider.app.data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gajanand on 30/6/18.
 */

public class CourseAPiDays implements Serializable {
    private String title;
    private String level1;
    private String level2;
    List<CourseList> level3;
    private String tips;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public List<CourseList> getLevel3() {
        return level3;
    }

    public void setLevel3(List<CourseList> level3) {
        this.level3 = level3;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
