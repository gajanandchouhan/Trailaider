package com.trailaider.app.data.persistance;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.trailaider.app.TrailaiderApp;
import com.trailaider.app.data.model.login.LoginResponseData;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Divya on 07-12-2017.
 */

public class TrailaiderPreferences {

    private static final String PREF_NAME = "trailaider_pref";
    public static final String IS_LOGGED_IN = "is_loggedin";
    private static TrailaiderPreferences dingingInPreferences;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editer;

    public static final String DEVICE_TOKEN = "device_token";

    public TrailaiderPreferences() {
        Context context = TrailaiderApp.getInsance().getApplicationContext();
        preferences = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        editer = preferences.edit();
    }

    public static TrailaiderPreferences getInstance() {
        if (dingingInPreferences == null) {
            dingingInPreferences = new TrailaiderPreferences();
        }
        return dingingInPreferences;
    }

    public void putString(String key, String value) {
        editer.putString(key, value).commit();

    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public void saveLoginData(LoginResponseData loginData) {
        editer.putString("login_data", new Gson().toJson(loginData)).commit();
    }

    public LoginResponseData getLoginData() {
        String login_data = preferences.getString("login_data", "");
        if (login_data.length() > 0) {
            return new Gson().fromJson(login_data, LoginResponseData.class);
        }
        return null;
    }

    public void cleaAll() {
        editer.clear().commit();
    }

    public void putBoolean(String key, boolean value) {
        editer.putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public void setProfileVisited(boolean visited) {
        editer.putBoolean("visited", visited).commit();
    }
    public boolean getProfileVisited(){
        return preferences.getBoolean("visited", false);
    }
}
