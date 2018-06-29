package com.trailaider.app.ui.fragment.review;

import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.model.review.ReviewDataModel;

import java.util.List;

/**
 * Created by gajanand on 12/1/18.
 */

public interface ReviewView extends BaseView {
    void onReviewAdded();

    void setReviewList(List<ReviewDataModel> data);

    void onRatingAdded();
}
