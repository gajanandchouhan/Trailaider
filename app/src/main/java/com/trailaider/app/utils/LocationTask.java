package com.trailaider.app.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by gajanand on 15/1/18.
 */

public class LocationTask extends AsyncTask<Void, Void, String> {

    private final Context mContext;
    private final Location location;
    private AddressListner addressListner;
    private ProgressDialog dialog;

    public LocationTask(Context mContext, Location location, AddressListner addressListner) {
        this.mContext = mContext;
        this.location = location;
        this.addressListner = addressListner;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(mContext, "", "", true, false);
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (addresses != null && addresses.size() > 0) {
                String cityName = addresses.get(0).getLocality();
                return cityName;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }


    @Override
    protected void onPostExecute(String s) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        addressListner.addressFetched(s);
    }
}


