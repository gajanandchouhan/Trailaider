package com.trailaider.app.data.model.chat;

import com.trailaider.app.data.model.BaseResponseModel;

/**
 * Created by gajanand on 11/2/18.
 */

public class SendMessageResponseModel extends BaseResponseModel {
    private MessageResponseData data;

    public void setData(MessageResponseData data) {
        this.data = data;
    }

    public MessageResponseData getData() {
        return data;
    }
}
