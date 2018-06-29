package com.trailaider.app.ui.activity.userprofile;

import android.content.Context;

import com.trailaider.app.R;
import com.trailaider.app.base.BasePresenter;
import com.trailaider.app.data.model.BaseResponseModel;
import com.trailaider.app.data.model.review.ReviewResponseModel;
import com.trailaider.app.data.model.userprofile.UserProfileResponseModel;
import com.trailaider.app.data.network.ApiController;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.network.RequestType;
import com.trailaider.app.data.network.ResponseHandler;
import com.trailaider.app.ui.fragment.review.ReviewView;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.HashMap;

import okhttp3.RequestBody;

/**
 * Created by gajanand on 12/1/18.
 */

public class UserProfilePresenter extends BasePresenter<UserProfileView> {
    UserProfileView view;

    public UserProfilePresenter(Context mContext) {
        super(mContext);
    }

    @Override
    public void initialiseView(UserProfileView view) {
        this.view = view;
    }


    public void getUserProfile(HashMap<String, String> body){
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.callGet(RequestType.REQ_TYPE_GET_PROFILE, new ResponseHandler<UserProfileResponseModel>() {
            @Override
            public void onResponse(UserProfileResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
//                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
                        view.setUserData(loginResponseModel.getData());
                    } else {
                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
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
        }, body);

    }

    public void addFriend(HashMap<String, String> body){
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext,RequestType.REQ_TYPE_ADD_FRIEND, new ResponseHandler<BaseResponseModel>() {
            @Override
            public void onResponse(BaseResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
                        view.onFriendAdded();
                    }
                    CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());

                } else {
                    CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.server_error));
                }
            }

            @Override
            public void onError() {
                view.hideProgress();
                CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.server_error));
            }
        }, body);

    }

}
