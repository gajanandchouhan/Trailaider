package com.trailaider.app.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class HeightPicker extends Dialog {

    private final Context context;
    private final SelectedListner selectedListner;
    private final String unitType;
    private static final int TYPE_METRIC = 1;
    private static final int TYPE_IMPERIAL = 2;
    List<String> cmList;
    List<String> ftList;
    List<String> inchesList;

    public HeightPicker(@NonNull Context context, String unitType, SelectedListner selectedListner,String selectedValue) {
        super(context, R.style.DialogSlideAnim);
        this.context = context;
        this.selectedListner = selectedListner;
        this.unitType = unitType;
        initView(selectedValue);
    }



    private void initView(String selectedValue) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_height);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(CommonUtils.getScreenWidth(context) - 150, WindowManager.LayoutParams.WRAP_CONTENT);
        final WheelPicker wheelPicker1 = findViewById(R.id.wheel_height_1);
        final WheelPicker wheelPicker2 = findViewById(R.id.wheel_height_2);
        if (unitType.equalsIgnoreCase(ConstantLib.UNIT_METRIC)) {
            wheelPicker2.setVisibility(View.GONE);
            cmList = getHeightInCMs();
            wheelPicker1.setData(cmList);
            if (!selectedValue.isEmpty())
                wheelPicker1.setSelectedItemPosition(cmList.indexOf(selectedValue));

        } else {
            ftList = getFeets();
            if (!selectedValue.isEmpty()){
                String tempfeet = selectedValue.substring(0, selectedValue.indexOf("'")+1);
                wheelPicker1.setSelectedItemPosition(ftList.indexOf(tempfeet));
            }
            if (!selectedValue.isEmpty()){
                String tempinch = selectedValue.substring(selectedValue.indexOf("'")+1, selectedValue.length());
                wheelPicker1.setSelectedItemPosition(ftList.indexOf(tempinch));
            }
            wheelPicker1.setData(ftList);
            inchesList = getInches();
            wheelPicker2.setData(inchesList);
        }

        findViewById(R.id.button_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (unitType.equalsIgnoreCase(ConstantLib.UNIT_METRIC)) {
                    int selectedItemPosition = wheelPicker1.getSelectedItemPosition();
                    selectedListner.onSelected(selectedItemPosition, cmList.get(selectedItemPosition));
                } else {
                    int selectedItemPosition = wheelPicker1.getSelectedItemPosition();
                    int inchPos = wheelPicker2.getSelectedItemPosition();
                    selectedListner.onSelected(selectedItemPosition, ftList.get(selectedItemPosition) + inchesList.get(inchPos));
                }

                dismiss();
            }
        });
        wheelPicker1.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                wheelPicker1.setSelectedItemPosition(position);
            }
        });

        wheelPicker2.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                wheelPicker2.setSelectedItemPosition(position);
            }
        });
    }

    private List getHeightInCMs() {
        List<String> list = new ArrayList<>();
        for (int i = 61; i <= 302; i++) {
            list.add(i + " cm");
        }
        return list;

    }

    private List<String> getFeets() {
        List<String> list = new ArrayList<>();
        for (int i = 2; i <= 9; i++) {
            list.add(i + "'");
        }
        return list;
    }

    private List<String> getInches() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= 11; i++) {
            list.add(i + "\"");
        }
        return list;
    }

    public interface SelectedListner {
        void onSelected(int position, String object);
    }
}
