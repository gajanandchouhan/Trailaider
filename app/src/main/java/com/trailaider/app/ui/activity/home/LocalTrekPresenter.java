package com.trailaider.app.ui.activity.home;

import android.content.Context;

import com.trailaider.app.R;
import com.trailaider.app.base.BasePresenter;
import com.trailaider.app.data.model.BaseResponseModel;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.trek.TrekImageModel;
import com.trailaider.app.data.model.trek.TrekResponseData;
import com.trailaider.app.data.network.ApiController;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.network.RequestType;
import com.trailaider.app.data.network.ResponseHandler;
import com.trailaider.app.data.persistance.DBHelper;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.trek.AddTrekView;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by gajanand on 20/1/18.
 */

public class LocalTrekPresenter extends BasePresenter<AddTrekView> {
    private AddTrekView view;

    public LocalTrekPresenter(Context mContext) {
        super(mContext);
    }

    @Override
    public void initialiseView(AddTrekView view) {
        this.view = view;
    }

    public void addTrek(List<TrekResponseData> list) {
     /*   ApiController apiController = ApiController.getInstance();
        for (final TrekResponseData trekResponseData : list) {
            HashMap<String, String> body = new HashMap<>();
            body.put("trek_name", trekResponseData.getTrek_name());
            body.put("trek_type", trekResponseData.getTrek_type());
            body.put("trek_duration", trekResponseData.getTrek_duration());
            body.put("trek_height", trekResponseData.getTrek_height());
            body.put("user_id", TrailaiderPreferences.getInstance().getLoginData().getId());
            body.put("latitude", trekResponseData.getLatitude());
            body.put("longitude", trekResponseData.getLongitude());
            body.put("address", trekResponseData.getAddress());

            apiController.call(mContext, RequestType.REQ_TYPE_ADD_TREK, new ResponseHandler<BaseResponseModel>() {
                @Override
                public void onResponse(BaseResponseModel loginResponseModel) {
                    if (loginResponseModel != null) {
                        if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                            view.onTrekAdded();
                            DBHelper.getInstance(mContext).deleteTrek(trekResponseData);
                        }
                    }
                }

                @Override
                public void onError() {
                    CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.server_error));
                }
            }, body);
        }

*/
        ApiController apiController = ApiController.getInstance();
        LoginResponseData loginData = TrailaiderPreferences.getInstance().getLoginData();
        for (final TrekResponseData trekResponseData : list) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            builder.addFormDataPart("user_id", loginData.getId());
            builder.addFormDataPart("trek_name", trekResponseData.getTrek_name());
            builder.addFormDataPart("trek_type", trekResponseData.getTrek_type());
//        builder.addFormDataPart("rating", String.valueOf(rating));
            builder.addFormDataPart("trek_duration", trekResponseData.getTrek_duration());
            builder.addFormDataPart("trek_height", trekResponseData.getTrek_height());
            List<TrekImageModel> trek_images = trekResponseData.getTrek_images();
            for (TrekImageModel trek_image : trek_images) {
                File file = new File(trek_image.getTrek_image());
                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                builder.addFormDataPart("trek_images[]", file.getName(), requestBody);
            }


            RequestBody finalRequestBody = builder.build();
            apiController.callMulipleImageUpoloads(RequestType.REQ_TYPE_ADD_TREK, new ResponseHandler<BaseResponseModel>() {
                @Override
                public void onResponse(BaseResponseModel loginResponseModel) {
                    if (loginResponseModel != null) {
                        if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                            DBHelper.getInstance(mContext).deleteTrek(trekResponseData);
                        } else {
                            CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
                        }

                    } else {
                        CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.server_error));
                    }
                }

                @Override
                public void onError() {
                    CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.server_error));
                }
            }, finalRequestBody);

        }


    }


}
