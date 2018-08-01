package com.trailaider.app.ui.activity.profile;

import android.content.Context;

import com.trailaider.app.R;
import com.trailaider.app.base.BasePresenter;
import com.trailaider.app.data.model.login.LoginResponseData;
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
 * Created by gajanand on 9/1/18.
 */

public class ProfilePresenter extends BasePresenter<ProfileView> {
    ProfileView view;

    public ProfilePresenter(Context mContext) {
        super(mContext);
    }

    @Override
    public void initialiseView(ProfileView view) {
        this.view = view;
    }

    public void updateProfile(HashMap<String, String> params, HashMap<String, File> files) {

        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext, RequestType.REQ_TYPE_UPDATE_PROFILE, new ResponseHandler<LoginResponseModel>() {
            @Override
            public void onResponse(LoginResponseModel baseResponseModel) {
                view.hideProgress();
                if (baseResponseModel != null) {
                    if (baseResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        view.setProfileData(baseResponseModel.getData());
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
        }, params, files);
    }
}
