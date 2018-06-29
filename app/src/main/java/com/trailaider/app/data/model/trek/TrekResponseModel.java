package com.trailaider.app.data.model.trek;

import com.trailaider.app.data.model.BaseResponseModel;

import java.util.List;

/**
 * Created by gajanand on 20/1/18.
 */

public class TrekResponseModel extends BaseResponseModel {

    public List<TrekResponseData> data;

    public void setData(List<TrekResponseData> data) {
        this.data = data;
    }

    public List<TrekResponseData> getData() {
        return data;
    }
}
