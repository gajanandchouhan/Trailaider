package com.trailaider.app.data;

import com.trailaider.app.data.model.BaseResponseModel;

/**
 * Created by gajanand on 30/6/18.
 */

public class CourseApiResponse extends BaseResponseModel {
    private CourseApiData data;

    public void setData(CourseApiData data) {
        this.data = data;
    }

    public CourseApiData getData() {
        return data;
    }
}
