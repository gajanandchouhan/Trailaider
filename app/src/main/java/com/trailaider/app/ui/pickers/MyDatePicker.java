package com.trailaider.app.ui.pickers;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.DatePicker;

import com.trailaider.app.R;


/**
 * Created by Divya on 13-12-2017.
 */

public class MyDatePicker extends DatePickerDialog {

    private CharSequence title;

    public MyDatePicker(@NonNull Context context, @Nullable OnDateSetListener listener, int year, int month, int dayOfMonth) {
        super(context, R.style.DialogThemeDatePicker, listener, year, month, dayOfMonth);
    }

    public void setPermanentTitle(CharSequence title) {
        this.title = title;
        setTitle(title);
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int month, int day) {
        super.onDateChanged(view, year, month, day);
        setTitle(title);
    }

}
