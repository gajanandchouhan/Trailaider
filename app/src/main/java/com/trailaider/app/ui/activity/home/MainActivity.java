package com.trailaider.app.ui.activity.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.model.trek.TrekResponseData;
import com.trailaider.app.data.network.CheckNetworkState;
import com.trailaider.app.data.persistance.DBHelper;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.activity.blog.BlogActivity;
import com.trailaider.app.ui.activity.friend.FriendActivity;
import com.trailaider.app.ui.activity.inbox.InboxActivity;
import com.trailaider.app.ui.activity.mypoint.MyPointActivity;
import com.trailaider.app.ui.activity.myrank.MyRankActivity;
import com.trailaider.app.ui.activity.profile.ProfileActivity;
import com.trailaider.app.ui.activity.setting.SettingActivity;
import com.trailaider.app.ui.activity.siginin.SignInActivity;
import com.trailaider.app.ui.activity.trek.AddTrekPresenter;
import com.trailaider.app.ui.activity.trek.AddTrekView;
import com.trailaider.app.ui.custom.FontCache;
import com.trailaider.app.ui.custom.FontTypes;
import com.trailaider.app.ui.fragment.trek.TrekFrament;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements DrawerAdapter.DrawerClickListener, AddTrekView {
    DrawerLayout mDrawerLayout;
    RecyclerView mDrawerList;
    DrawerAdapter adapter;
    int currentpos = 0;
    LinearLayout layoutDrawer;
    private ActionBar actionBar;
    private Toolbar toolbar;
    TextView textViewName;
    ImageView imageView;
    private TextView textViewCity;
    private TabLayout tabLayout;
    private ViewPager pager;
    private HomePagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = findViewById(R.id.drawer);
        mDrawerList = findViewById(R.id.left_drawer);
        layoutDrawer = findViewById(R.id.layout_drawer);
        textViewName = findViewById(R.id.textView_name);
        textViewCity = findViewById(R.id.textView_city);
        imageView = findViewById(R.id.image_view_profile);
        toolbar = findViewById(R.id.toolbar);
        findViewById(R.id.imageView_blog).setOnClickListener(this);
        findViewById(R.id.imageView_friend).setOnClickListener(this);
        findViewById(R.id.imageView_inbox).setOnClickListener(this);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DrawerAdapter(this, getDrawerItems(), this);
        mDrawerList.setAdapter(adapter);
        LoginResponseData loginData = TrailaiderPreferences.getInstance().getLoginData();
        GlideApp.with(imageView).load(loginData.getUser_image()).into(imageView);
        textViewCity.setText(loginData.getCity());
        textViewName.setText(String.format("%s %s", loginData.getFirstname(), loginData.getLastname()));

        tabLayout = findViewById(R.id.tab_layout);
        pager = findViewById(R.id.pager);
        setupViewPager(pager);
        tabLayout.setupWithViewPager(pager);
        changeTabsFont();
        setNotifcationClickListner(findViewById(R.id.image_view_notification));
    }

    private void setupViewPager(ViewPager pager) {
        pagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
    }

    private List<DrawerItem> getDrawerItems() {
        List<DrawerItem> drawerItemList = new ArrayList<DrawerItem>();
        drawerItemList.add(new DrawerItem(getString(R.string.myprofile), R.drawable.camera_black));
//        drawerItemList.add(new DrawerItem(getString(R.string.my_points), R.drawable.camera_black));
//        drawerItemList.add(new DrawerItem(getString(R.string.myrank), R.drawable.camera_black));
        drawerItemList.add(new DrawerItem(getString(R.string.inbox), R.drawable.camera_black));
        drawerItemList.add(new DrawerItem(getString(R.string.friends), R.drawable.camera_black));
        drawerItemList.add(new DrawerItem(getString(R.string.setting), R.drawable.camera_black));
        drawerItemList.add(new DrawerItem(getString(R.string.logout), R.drawable.camera_black));
        return drawerItemList;
    }

    @Override
    public void initializePresneter() {

    }

    @Override
    public void initializeView() {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.imageView_blog:
                CommonUtils.startActivity(this, BlogActivity.class);
                break;
            case R.id.imageView_friend:
                CommonUtils.startActivity(this, FriendActivity.class);
                break;
            case R.id.imageView_inbox:
                CommonUtils.startActivity(this, InboxActivity.class);
                break;
        }
    }

    @Override
    public void onDrawerClick(int position) {
        switch (position) {
            case 0:
                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra(ConstantLib.FROM_SLIDER, true);
                startActivity(intent);
                break;
         /*   case 1:
                CommonUtils.startActivity(this, MyPointActivity.class);
                break;
            case 2:
                CommonUtils.startActivity(this, MyRankActivity.class);
                break;*/
            case 1:
                CommonUtils.startActivity(this, InboxActivity.class);
                break;
            case 2:
                CommonUtils.startActivity(this, FriendActivity.class);
                break;
            case 3:
                CommonUtils.startActivity(this, SettingActivity.class);
                break;
            case 4:
                TrailaiderPreferences.getInstance().cleaAll();
                CommonUtils.startActivity(this, SignInActivity.class, null, true);
                break;
        }
        mDrawerLayout.closeDrawer(layoutDrawer);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(layoutDrawer);
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeTabsFont() {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(FontCache.getTypeface(FontTypes.REGULAR, this), Typeface.NORMAL);
                }
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(layoutDrawer)) {
            mDrawerLayout.closeDrawer(layoutDrawer);
        } else {
            super.onBackPressed();
        }
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (CheckNetworkState.isOnline(context)) {
                List<TrekResponseData> localTrekList = DBHelper.getInstance(context).getLocalTrekList();
                if (localTrekList != null && localTrekList.size() > 0) {
                    saveLocalLIST(localTrekList);

                }

//                CommonUtils.showToast(context,"Internet connected");
            } else {
//                CommonUtils.showToast(context,"Internet disconnedted");
            }
        }
    };

    private void saveLocalLIST(List<TrekResponseData> localTrekList) {
        LocalTrekPresenter presenter = new LocalTrekPresenter(this);
        presenter.initialiseView(this);
        presenter.addTrek(localTrekList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override
    public void onTrekAdded() {

    }
}

