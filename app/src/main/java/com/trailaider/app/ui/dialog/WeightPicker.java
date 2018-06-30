package com.trailaider.app.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.aigestudio.wheelpicker.WheelPicker;
import com.trailaider.app.R;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Divya on 19-12-2017.
 */

public class WeightPicker extends Dialog {

    private final Context context;
    private final SelectedListner selectedListner;
    private final String unitType;
    private static final int TYPE_METRIC = 1;
    private static final int TYPE_IMPERIAL = 2;

    public WeightPicker(@NonNull Context context, String unitType, SelectedListner selectedListner, String trim) {
        super(context, R.style.DialogSlideAnim);
        this.context = context;
        this.selectedListner = selectedListner;
        this.unitType = unitType;
        initView(trim);
    }

    private void initView(String trim) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_weight);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(CommonUtils.getScreenWidth(context) - 150, WindowManager.LayoutParams.WRAP_CONTENT);
        final List<String> weightList = getWeightList();
        final WheelPicker wheelPicker = findViewById(R.id.wheel_weight);
        wheelPicker.setData(weightList);
        if (!trim.isEmpty())
            wheelPicker.setSelectedItemPosition(weightList.indexOf(trim));
        else
            wheelPicker.setSelectedItemPosition(10);
        findViewById(R.id.button_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedItemPosition = wheelPicker.getSelectedItemPosition();
                selectedListner.onSelected(selectedItemPosition, weightList.get(selectedItemPosition));
                dismiss();
            }
        });
        wheelPicker.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                wheelPicker.setSelectedItemPosition(position);
            }
        });
    }

    private List<String> getWeightList() {
        List<String> list = new ArrayList<>();
        switch (unitType) {
            case ConstantLib.UNIT_METRIC:
                for (int i = 27; i <= 227; i++) {
                    list.add(i + " kgs");
                }
                break;
            case ConstantLib.UNIT_IMPERIAL:
                for (int i = 30; i <= 500; i++) {
                    list.add(i + " lbs");
                }
                break;
        }
        return list;
    }


    public interface SelectedListner {
        void onSelected(int position, String object);
    }
}
