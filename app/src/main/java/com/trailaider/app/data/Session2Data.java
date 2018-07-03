package com.trailaider.app.data;

import java.io.Serializable;

/**
 * Created by gajanand on 3/7/18.
 */

public class Session2Data implements Serializable{
    private String title;
    private String time;
    private String unit;
    private String video;
    private String restTime;
    private String restUnit;
    private int progress;

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getRestTime() {
        return restTime;
    }

    public void setRestTime(String restTime) {
        this.restTime = restTime;
    }

    public String getRestUnit() {
        return restUnit;
    }

    public void setRestUnit(String restUnit) {
        this.restUnit = restUnit;
    }
}
