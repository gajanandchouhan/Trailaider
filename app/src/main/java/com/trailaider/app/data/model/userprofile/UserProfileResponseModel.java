package com.trailaider.app.data.model.userprofile;

import com.trailaider.app.data.model.BaseResponseModel;

/**
 * Created by gajanand on 28/1/18.
 */

public class UserProfileResponseModel extends BaseResponseModel {

    private UserProfileData data;

    public void setData(UserProfileData data) {
        this.data = data;
    }

    public UserProfileData getData() {
        return data;
    }
}
