package com.trailaider.app.ui.activity.blog;

import android.content.Context;

import com.trailaider.app.base.BasePresenter;

import java.util.HashMap;

/**
 * Created by gajanand on 11/2/18.
 */

public class BlogPresenter extends BasePresenter<BlogView> {
    private BlogView view;

    public BlogPresenter(Context mContext) {
        super(mContext);
    }

    @Override
    protected void initialiseView(BlogView view) {
        this.view = view;
    }

    public void getBlog(HashMap<String, String> body) {
/*
        if (!CheckNetworkState.isOnline(mContext)) {
            CommonUtils.showSnakeBar(mContext, mContext.getString(R.string.no_internet));
            return;
        }
        view.showProgress();
        ApiController apiController = ApiController.getInstance();
        apiController.callGet(RequestType.GET_INBOX, new ResponseHandler<MessageResponseModel>() {
            @Override
            public void onResponse(MessageResponseModel loginResponseModel) {
                view.hideProgress();
                if (loginResponseModel != null) {
                    if (loginResponseModel.getStatus().equalsIgnoreCase(ConstantLib.SUCCESS)) {
                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
                        view.setInboxList(loginResponseModel.getData());
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
*/

    }
}
