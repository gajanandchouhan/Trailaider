package com.trailaider.app.ui.fragment.courses;

import android.content.Context;

import com.trailaider.app.R;
import com.trailaider.app.base.BasePresenter;
import com.trailaider.app.data.CourseApiResponse;
import com.trailaider.app.data.network.ApiController;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.network.RequestType;
import com.trailaider.app.data.network.ResponseHandler;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.io.File;
import java.util.HashMap;

/**
 * Created by gajanand on 12/1/18.
 */

public class CoursePresenter extends BasePresenter<CourseView> {
    CourseView view;

    public CoursePresenter(Context mContext) {
        super(mContext);
    }

    @Override
    public void initialiseView(CourseView view) {
        this.view = view;
    }

    public void getCourses(HashMap<String, String> params) {

        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext, RequestType.REQ_GET_COURSES, new ResponseHandler<CourseApiResponse>() {
            @Override
            public void onResponse(CourseApiResponse baseResponseModel) {
                view.hideProgress();
                if (baseResponseModel != null) {
                    if (baseResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        view.setCourseApiResponse(baseResponseModel);
                    } else {
                        CommonUtils.showSnakeBar(mContext, baseResponseModel.getMessage());
                    }
                } else {
                    CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.server_error));
                }
            }

            @Override
            public void onError() {
                view.hideProgress();
                CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.server_error));
            }
        }, params);
    }
}
