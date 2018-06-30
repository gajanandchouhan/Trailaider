package com.trailaider.app.ui.fragment.courses;

import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.CourseApiResponse;

/**
 * Created by gajanand on 12/1/18.
 */

public interface CourseView extends BaseView {
    void setCourseApiResponse(CourseApiResponse baseResponseModel);
}
