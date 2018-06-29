package com.trailaider.app.ui.activity.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.ui.activity.BaseActivity;

/**
 * Created by gajanand on 17/1/18.
 */

public class TCAndPrivacyActivity extends BaseActivity {


    private Toolbar toolbar;
    private ActionBar actionBar;
    private TextView textViewTitle;
    private TextView textViewText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activi_tc_privacy);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        textViewTitle = findViewById(R.id.textView_title);
        textViewTitle.setText(getIntent().getStringExtra("title"));
        textViewText.setText(getIntent().getStringExtra("text"));
    }

    @Override
    public void initializePresneter() {

    }

    @Override
    public void initializeView() {
        textViewText = findViewById(R.id.textView_text);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
