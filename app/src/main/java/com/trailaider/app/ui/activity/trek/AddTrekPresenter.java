package com.trailaider.app.ui.activity.trek;

import android.content.Context;

import com.trailaider.app.R;
import com.trailaider.app.base.BasePresenter;
import com.trailaider.app.data.model.BaseResponseModel;
import com.trailaider.app.data.model.TrekTableModel;
import com.trailaider.app.data.model.trek.TrekImageModel;
import com.trailaider.app.data.model.trek.TrekResponseData;
import com.trailaider.app.data.network.ApiController;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.network.RequestType;
import com.trailaider.app.data.network.ResponseHandler;
import com.trailaider.app.data.persistance.DBHelper;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;

/**
 * Created by gajanand on 20/1/18.
 */

public class AddTrekPresenter extends BasePresenter<AddTrekView> {
    private AddTrekView view;

    public AddTrekPresenter(Context mContext) {
        super(mContext);
    }

    @Override
    public void initialiseView(AddTrekView view) {
        this.view = view;
    }

    /*public void addTrek(HashMap<String, String> body) {
        if (!CheckNetworkState.isOnline(mContext)) {
            TrekResponseData trekTableModel = new TrekResponseData();
            trekTableModel.setAddress(body.get("address"));
            trekTableModel.setLatitude(body.get("latitude"));
            trekTableModel.setLongitude(body.get("longitude"));
            trekTableModel.setTrek_status("0");
            trekTableModel.setTrek_duration(body.get("trek_duration"));
            trekTableModel.setTrek_height(body.get("trek_height"));
            trekTableModel.setTrek_name(body.get("trek_name"));
            trekTableModel.setTrek_type(body.get("trek_type"));
            DBHelper.getInstance(mContext).inserTrekData(trekTableModel);
            CommonUtils.showToast(mContext,mContext.getString(R.string.trek_added_success));
            view.onTrekAdded();
//            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.call(mContext, RequestType.REQ_TYPE_ADD_TREK, new ResponseHandler<BaseResponseModel>() {
            @Override
            public void onResponse(BaseResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        view.onTrekAdded();
                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());

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
    }*/
    public void addTrek(RequestBody body, TrekResponseData data, List<String> list){
        if (!CheckNetworkState.isOnline(mContext)) {
            data.setTrek_status("0");
            DBHelper.getInstance(mContext).inserTrekData(data,list);
            CommonUtils.showToast(mContext,mContext.getString(R.string.trek_added_success));
            view.onTrekAdded();
//            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.callMulipleImageUpoloads(RequestType.REQ_TYPE_ADD_TREK, new ResponseHandler<BaseResponseModel>() {
            @Override
            public void onResponse(BaseResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
                        view.onTrekAdded();
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
