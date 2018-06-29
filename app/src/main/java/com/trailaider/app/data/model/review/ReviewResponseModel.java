package com.trailaider.app.data.model.review;

import com.trailaider.app.data.model.BaseResponseModel;

import java.util.List;

/**
 * Created by gajanand on 23/1/18.
 */

public class ReviewResponseModel extends BaseResponseModel {
    private String total_records;
    private List<ReviewDataModel> data;

    public String getTotal_records() {
        return total_records;
    }

    public void setTotal_records(String total_records) {
        this.total_records = total_records;
    }

    public List<ReviewDataModel> getData() {
        return data;
    }

    public void setData(List<ReviewDataModel> data) {
        this.data = data;
    }
}
