package com.trailaider.app.ui.fragment.friends;

import android.content.Context;

import com.trailaider.app.R;
import com.trailaider.app.base.BasePresenter;
import com.trailaider.app.data.model.BaseResponseModel;
import com.trailaider.app.data.network.ApiController;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.network.RequestType;
import com.trailaider.app.data.network.ResponseHandler;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.HashMap;

/**
 * Created by gajanand on 26/2/18.
 */

public class FriendPresenter extends BasePresenter<FriendView> {
    FriendView view;

    public FriendPresenter(Context mContext) {
        super(mContext);
    }

    @Override
    public void initialiseView(FriendView view) {
        this.view = view;
    }

    public void unFriend(HashMap<String,String> body){
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext, RequestType.REQ_UNFRIEND, new ResponseHandler<BaseResponseModel>() {
            @Override
            public void onResponse(BaseResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view.onUnfriended();
                            }
                        },2000);

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

    public void acceptFriend(HashMap<String, String> body) {
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext, RequestType.REQ_ACCEPT, new ResponseHandler<BaseResponseModel>() {
            @Override
            public void onResponse(BaseResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view.onAccepted();
                            }
                        },2000);

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

    public void reject(HashMap<String, String> body) {
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext, RequestType.REQ_REJECT,new ResponseHandler<BaseResponseModel>() {
            @Override
            public void onResponse(BaseResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view.onReject();
                            }
                        },2000);

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
}
