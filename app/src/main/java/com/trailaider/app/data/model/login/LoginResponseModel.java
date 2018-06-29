package com.trailaider.app.data.model.login;

import com.trailaider.app.data.model.BaseResponseModel;

/**
 * Created by gajanand on 7/1/18.
 */

public class LoginResponseModel extends BaseResponseModel {

    private LoginResponseData data;

    public void setData(LoginResponseData data) {
        this.data = data;
    }

    public LoginResponseData getData() {
        return data;
    }
}
