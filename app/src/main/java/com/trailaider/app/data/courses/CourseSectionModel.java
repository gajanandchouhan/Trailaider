package com.trailaider.app.data.courses;

import java.io.Serializable;

/**
 * Created by gajanand on 1/4/18.
 */

public class CourseSectionModel implements Serializable {

    String actionLabel;
    String actionDesc;
    long time;
    private boolean isCompleted;
    private String distance;
    private String speed;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public CourseSectionModel(String actionLabel, String actionDesc, long time) {
        this.actionLabel = actionLabel;
        this.actionDesc = actionDesc;
        this.time = time;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public long getTime() {
        return time;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
