package com.trailaider.app.base;

import android.content.Context;

/**
 * Created by gajanand on 4/1/18.
 */

public abstract class BasePresenter<T> {
    public final Context mContext;

    public BasePresenter(Context mContext) {
        this.mContext = mContext;

    }

    protected abstract void initialiseView(T view);
}
