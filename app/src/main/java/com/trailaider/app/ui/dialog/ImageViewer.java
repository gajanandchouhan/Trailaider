package com.trailaider.app.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.ui.adapter.ImagePagerAdapter;
import com.trailaider.app.utils.CommonUtils;

import java.util.List;

/**
 * Created by Divya on 19-12-2017.
 */

public class ImageViewer extends Dialog {

    private final Context context;
    private final int pos;
    List list;

    public ImageViewer(@NonNull Context context, List imageUrl, int pos) {
        super(context, R.style.DialogSlideAnim);
        this.context = context;
        this.list = imageUrl;
        this.pos = pos;
        initView();
    }

    private void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setGravity(Gravity.CENTER);
        setContentView(R.layout.dialog_image);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(CommonUtils.getScreenWidth(context), CommonUtils.getScreenHeight(context));
        findViewById(R.id.imageView_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(new ImagePagerAdapter(list));
        pager.setCurrentItem(pos);
    }

}
