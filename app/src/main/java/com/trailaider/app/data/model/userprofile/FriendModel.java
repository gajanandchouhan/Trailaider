package com.trailaider.app.data.model.userprofile;

import com.trailaider.app.data.model.login.LoginResponseData;

/**
 * Created by gajanand on 29/1/18.
 */

public class FriendModel extends LoginResponseData {
    private String frnd_status;
    private String request_id;

    public void setFrnd_status(String frnd_status) {
        this.frnd_status = frnd_status;
    }

    public String getFrnd_status() {
        return frnd_status;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }
}
