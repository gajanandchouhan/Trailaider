package com.trailaider.app.ui.activity.inbox;

import android.content.Context;

import com.trailaider.app.R;
import com.trailaider.app.base.BasePresenter;
import com.trailaider.app.data.model.chat.MessageResponseModel;
import com.trailaider.app.data.network.ApiController;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.network.RequestType;
import com.trailaider.app.data.network.ResponseHandler;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.HashMap;

/**
 * Created by gajanand on 11/2/18.
 */

public class InboxPresenter extends BasePresenter<InboxView> {
    private InboxView view;

    public InboxPresenter(Context mContext) {
        super(mContext);
    }

    @Override
    protected void initialiseView(InboxView view) {
        this.view = view;
    }

    public void getInbox(HashMap<String, String> body) {
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
//                        CommonUtils.showSnakeBar(mContext, loginResponseModel.getMessage());
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

    }
}
