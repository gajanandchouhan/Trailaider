package com.trailaider.app.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;


import com.trailaider.app.R;
import com.trailaider.app.utils.CommonUtils;

import java.util.List;

/**
 * Created by Divya on 19-12-2017.
 */

public class SelectionListDialog extends Dialog {

    private final Context context;
    private final SelectedListner selectedListner;
    private final List<Object> list;

    public SelectionListDialog(@NonNull Context context, List list, SelectedListner selectedListner) {
        super(context, R.style.DialogSlideAnim);
        this.context = context;
        this.selectedListner = selectedListner;
        this.list=list;
        initView();
    }

    private void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_selection_popup);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(CommonUtils.getScreenWidth(context) - 150, WindowManager.LayoutParams.WRAP_CONTENT);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        setAadapter(recyclerView);
    }

    private void setAadapter(RecyclerView recyclerView) {
        SelectionListAdapter adapter = new SelectionListAdapter(this, context, list, selectedListner);
        recyclerView.setAdapter(adapter);
    }


    public interface SelectedListner<T> {
        void onSelected(int position, T object);
    }
}
