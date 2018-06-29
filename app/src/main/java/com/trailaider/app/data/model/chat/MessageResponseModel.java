package com.trailaider.app.data.model.chat;

import com.trailaider.app.data.model.BaseResponseModel;

import java.util.List;

/**
 * Created by gajanand on 11/2/18.
 */

public class MessageResponseModel extends BaseResponseModel {
    private String total_records;
    private List<MessageResponseData> data;

    public void setData(List<MessageResponseData> data) {
        this.data = data;
    }

    public List<MessageResponseData> getData() {
        return data;
    }
}
