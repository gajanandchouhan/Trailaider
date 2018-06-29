package com.trailaider.app.data.network;

/**
 * Created by JAIN COMPUTERS on 11/18/2017.
 */

public interface RequestType {
    byte REQ_TYPE_LOGIN = 1;
    byte REQ_TYPE_REGISTER = 2;
    byte REQ_TYPE_FORGOT_PASS = 3;
    byte REQ_TYPE_VERIFY_OTP = 4;
    byte REQ_TYPE_CHANGE_PASSWORD = 5;
    byte REQ_TYPE_UPDATE_PROFILE = 6;
    byte REQ_TYPE_ADD_TREK = 7;
    byte REQ_TYPE_GET_TREK = 8;
    byte REQ_ADD_REVIEW=9;
    byte REQ_TYPE_GET_REVIEW = 10;
    byte REQ_TYPE_ADD_RATING=11;
    byte REQ_TYPE_GET_PROFILE = 12;
    byte REQ_TYPE_ADD_FRIEND=13;
    byte GET_CHAT = 14;
    byte SEND_SMS = 15;
    byte GET_INBOX=16;
    byte REQ_RESET_PASS = 17;
    byte REQ_UNFRIEND = 18;
    byte REQ_ACCEPT=19;
    byte REQ_REJECT = 20;
    byte REQ_GET_COURSES=21;
}
