package com.trailaider.app.ui.activity.siginin;

import android.content.Context;

import com.trailaider.app.R;
import com.trailaider.app.base.BasePresenter;
import com.trailaider.app.data.model.login.LoginResponseModel;
import com.trailaider.app.data.network.ApiController;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.network.RequestType;
import com.trailaider.app.data.network.ResponseHandler;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.HashMap;

/**
 * Created by gajanand on 7/1/18.
 */

public class SiginInPresenter extends BasePresenter<SignInView> {
    SignInView view;

    public SiginInPresenter(Context mContext) {
        super(mContext);
    }

    @Override
    protected void initialiseView(SignInView view) {
        this.view = view;
    }

    public void doLogin(HashMap<String, String> body) {
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext, RequestType.REQ_TYPE_LOGIN, new ResponseHandler<LoginResponseModel>() {
            @Override
            public void onResponse(LoginResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        TrailaiderPreferences.getInstance().saveLoginData(loginResponseModel.getData());
                        view.moveToHome(loginResponseModel.getData());
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
