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
import android.widget.EditText;
import android.widget.RadioGroup;

import com.trailaider.app.R;
import com.trailaider.app.utils.CommonUtils;

import java.util.List;

/**
 * Created by Divya on 19-12-2017.
 */

public class TrekTypeSelectionDialog extends Dialog {

    private final Context context;
    private final SelectedListner lisner;
    private RadioGroup radioGroup;
    private EditText editTextCompany;

    public TrekTypeSelectionDialog(@NonNull Context context, SelectedListner listner) {
        super(context, R.style.DialogSlideAnim);
        this.context = context;
        this.lisner = listner;
        initView();
    }

    private void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_trektype);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(CommonUtils.getScreenWidth(context) - 150, WindowManager.LayoutParams.WRAP_CONTENT);
        radioGroup = findViewById(R.id.radio);
        editTextCompany = findViewById(R.id.edit_text_cmpny);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioGroup.getCheckedRadioButtonId() == R.id.button_company) {
                    editTextCompany.setVisibility(View.VISIBLE);
                } else {
                    editTextCompany.setVisibility(View.GONE);
                    editTextCompany.setText("");
                }
            }
        });

        findViewById(R.id.button_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = "";
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.button_company) {
                    type = editTextCompany.getText().toString().trim();
                    if (type.isEmpty())
                        editTextCompany.setError("Enter company name.");
                    else {
                        lisner.onSelected(type);
                        dismiss();
                    }
                } else if (checkedRadioButtonId == R.id.button_solo) {
                    type = "Solo";
                    lisner.onSelected(type);
                    dismiss();
                } else if (checkedRadioButtonId == R.id.button_friend) {
                    type = "With Friends";
                    lisner.onSelected(type);
                    dismiss();
                } else {
                    CommonUtils.showToast(context, context.getString(R.string.select_type));
                }
            }
        });
    }

    public interface SelectedListner {
        void onSelected(String type);
    }

}
