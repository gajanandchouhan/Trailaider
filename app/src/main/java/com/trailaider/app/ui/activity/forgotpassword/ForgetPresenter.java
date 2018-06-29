package com.trailaider.app.ui.activity.forgotpassword;

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
import java.util.logging.Handler;

/**
 * Created by gajanand on 9/1/18.
 */

class ForgetPresenter extends BasePresenter<ForgotPasswordView> {
    ForgotPasswordView view;

    public ForgetPresenter(Context mContext) {
        super(mContext);
    }

    @Override
    protected void initialiseView(ForgotPasswordView view) {
        this.view = view;
    }

    public void doForgetPassword(HashMap<String, String> body) {
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext, RequestType.REQ_TYPE_FORGOT_PASS, new ResponseHandler<BaseResponseModel>() {
            @Override
            public void onResponse(BaseResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view.onForgotPasswordSuccess();
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

    public void resetPassword(HashMap<String, String> body) {
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext, RequestType.REQ_RESET_PASS, new ResponseHandler<BaseResponseModel>() {
            @Override
            public void onResponse(BaseResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                view.onResetSuccess();
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
