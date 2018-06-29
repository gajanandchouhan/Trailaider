package com.trailaider.app.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.trailaider.app.data.network.CheckNetworkState;

/**
 * Created by gajanand on 21/1/18.
 */

public class NetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (CheckNetworkState.isOnline(context)){
            CommonUtils.showToast(context,"Internet connected");

        }
        else{
            CommonUtils.showToast(context,"Internet disconnedted");
        }
    }
}
