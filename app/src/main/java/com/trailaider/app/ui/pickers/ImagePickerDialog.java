package com.trailaider.app.ui.pickers;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.trailaider.app.R;
import com.trailaider.app.utils.CommonUtils;

/**
 * Created by Divya on 28-11-2017.
 */

public class ImagePickerDialog extends Dialog implements View.OnClickListener {
    private final Context context;
    private ClickListener clickListener;

    public ImagePickerDialog(@NonNull Context context, ClickListener clickListener) {
        super(context, R.style.DialogSlideAnim);
        this.context = context;
        this.clickListener = clickListener;
        initView();
    }

    private void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_image_picker);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(CommonUtils.getScreenWidth(context) - 200, WindowManager.LayoutParams.WRAP_CONTENT);
        findViewById(R.id.layout_camera).setOnClickListener(this);
        findViewById(R.id.layout_gallery).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_camera:
                clickListener.onClick(1);
                break;
            case R.id.layout_gallery:
                clickListener.onClick(2);
                break;
        }
        dismiss();
    }

    interface ClickListener {
        void onClick(int type);
    }

}
