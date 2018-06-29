package com.trailaider.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by gajanand on 4/1/18.
 */

public class TrailaiderApp extends Application {
    private static TrailaiderApp insance;

    public static Context getInsance() {
        return insance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        insance = this;
    }
}
