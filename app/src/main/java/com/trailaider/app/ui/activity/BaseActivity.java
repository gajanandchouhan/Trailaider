package com.trailaider.app.ui.activity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.trailaider.app.base.BaseView;
import com.trailaider.app.data.model.trek.TrekResponseData;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.persistance.DBHelper;
import com.trailaider.app.utils.CommonUtils;

import java.util.List;

/**
 * Created by gajanand on 4/1/18.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView, View.OnClickListener {

    private ProgressDialog dialog;
    private Uri uri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializePresneter();
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    public abstract void initializePresneter();

    public abstract void initializeView();

    @Override
    public void showProgress() {
        dialog = ProgressDialog.show(this, "", "", true, false);
    }

    @Override
    public void hideProgress() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void onClick(View view) {

    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public Uri getUri() {
        return uri;
    }



}
