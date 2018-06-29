package com.trailaider.app.ui.fragment.trek;

import android.content.Context;

import com.trailaider.app.R;
import com.trailaider.app.base.BasePresenter;
import com.trailaider.app.data.model.BaseResponseModel;
import com.trailaider.app.data.model.trek.TrekResponseModel;
import com.trailaider.app.data.network.ApiController;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.network.RequestType;
import com.trailaider.app.data.network.ResponseHandler;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.HashMap;

import okhttp3.RequestBody;

/**
 * Created by gajanand on 12/1/18.
 */

public class TrekPresenter extends BasePresenter<TrekView> {
    TrekView view;

    public TrekPresenter(Context mContext) {
        super(mContext);
    }

    @Override
    protected void initialiseView(TrekView view) {
        this.view = view;
    }


    public void getTrek(HashMap<String, String> body) {
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.callGet(RequestType.REQ_TYPE_GET_TREK, new ResponseHandler<TrekResponseModel>() {
            @Override
            public void onResponse(TrekResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        view.setTrekList(loginResponseModel.getData());
//                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());

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

