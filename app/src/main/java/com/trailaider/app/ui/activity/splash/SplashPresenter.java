package com.trailaider.app.ui.activity.splash;

import android.content.Context;
import android.os.Handler;

import com.trailaider.app.base.BasePresenter;

/**
 * Created by gajanand on 4/1/18.
 */

public class SplashPresenter extends BasePresenter<SplasView> {
    private static final long SPLASH_TIMEOUT = 3000;
    SplasView view;

    public SplashPresenter(Context mContext) {
        super(mContext);
    }

    @Override
    public void initialiseView(SplasView view) {
        this.view = view;
    }

    public void delaySplash() {
        handler.postDelayed(mRunnable, SPLASH_TIMEOUT);
    }

    public void cancelSplash() {
        handler.removeCallbacks(mRunnable);
    }

    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            view.startNextActivity();
        }
    };
    Handler handler = new Handler();

}
