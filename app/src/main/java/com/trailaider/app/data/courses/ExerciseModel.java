package com.trailaider.app.data.courses;

import java.io.Serializable;

/**
 * Created by gajanand on 14/4/18.
 */

public class ExerciseModel implements Serializable {
    private String name;
    private int rest;
    private long seconds;
    private int progress;

    public ExerciseModel(String name, int rest, long seconds) {
        this.name = name;
        this.rest = rest;
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public int getRest() {
        return rest;
    }

    public long getSeconds() {
        return seconds;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
