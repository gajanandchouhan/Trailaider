package com.trailaider.app.data.courses;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gajanand on 30/3/18.
 */

public class CourseDataModel implements Serializable {
    private final String heading;
    private final List<ExerciseModel> exercise;
    List<CourseSectionModel> courseSectionModelList;
    String tips;

    public CourseDataModel(String s, List<CourseSectionModel> courseSectionModelList, String tips, List<ExerciseModel> exerciseModelList2) {
        this.courseSectionModelList = courseSectionModelList;
        this.tips = tips;
        this.heading=s;
        this.exercise=exerciseModelList2;
    }

    public List<CourseSectionModel> getCourseSectionModelList() {
        return courseSectionModelList;
    }

    public String getTips() {
        return tips;
    }

    public String getHeading() {
        return heading;
    }

    public List<ExerciseModel> getExercise() {
        return exercise;
    }
}