package com.trailaider.app.data.model.chat;

import com.trailaider.app.data.model.userprofile.UserProfileData;

/**
 * Created by gajanand on 11/2/18.
 */

public class MessageResponseData {
    private String message_id;
    private String from_id;
    private String to_id;
    private String message;
    private String created_at;
    private String updated_at;
    private UserProfileData user_details;

    public void setUser_details(UserProfileData user_details) {
        this.user_details = user_details;
    }

    public UserProfileData getUser_details() {
        return user_details;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getFrom_id() {
        return from_id;
    }

    public void setFrom_id(String from_id) {
        this.from_id = from_id;
    }

    public String getTo_id() {
        return to_id;
    }

    public void setTo_id(String to_id) {
        this.to_id = to_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
