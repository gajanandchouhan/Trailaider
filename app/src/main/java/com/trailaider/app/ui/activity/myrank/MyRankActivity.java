package com.trailaider.app.ui.activity.myrank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.friend.FriendListAdapter;
import com.trailaider.app.utils.GridSpacingItemDecoration;

/**
 * Created by gajanand on 17/1/18.
 */

public class MyRankActivity extends BaseActivity {


    private Toolbar toolbar;
    private ActionBar actionBar;
    private RecyclerView recyclerView;
    private TextView textViewTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myranks);
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.recycler_view);
        textViewTitle=findViewById(R.id.textView_title);
        textViewTitle.setText(getString(R.string.myrank));
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(new MyRankAdapter(this));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3,50,true));
    }

    @Override
    public void initializePresneter() {

    }

    @Override
    public void initializeView() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
