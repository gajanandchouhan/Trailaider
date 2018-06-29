package com.trailaider.app.data.model;

/**
 * Created by gajanand on 7/1/18.
 */

public class BaseResponseModel {

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
