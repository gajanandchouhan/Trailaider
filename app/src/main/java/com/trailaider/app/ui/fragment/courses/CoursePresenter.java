package com.trailaider.app.ui.fragment.courses;

import android.content.Context;

import com.trailaider.app.R;
import com.trailaider.app.base.BasePresenter;
import com.trailaider.app.data.model.BaseResponseModel;
import com.trailaider.app.data.model.login.LoginResponseModel;
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
    protected void initialiseView(CourseView view) {
        this.view = view;
    }

    public void getCourses(HashMap<String, String> params, HashMap<String, File> files) {

        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext, RequestType.REQ_GET_COURSES, new ResponseHandler<BaseResponseModel>() {
            @Override
            public void onResponse(BaseResponseModel baseResponseModel) {
                view.hideProgress();
                if (baseResponseModel != null) {
                    CommonUtils.showSnakeBar(mContext, baseResponseModel.getMessage());
                    if (baseResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        CommonUtils.showToast(mContext,baseResponseModel.getMessage());
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
