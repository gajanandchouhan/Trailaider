package com.trailaider.app.ui.activity.walking;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.trailaider.app.R;
import com.trailaider.app.data.courses.CourseDataModel;
import com.trailaider.app.data.courses.CourseSectionModel;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.data.persistance.TrailaiderPreferences;
import com.trailaider.app.service.TimerService;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.adapter.CourseSectionAdapter;
import com.trailaider.app.utils.CommonUtils;
import com.trailaider.app.utils.ConstantLib;
import com.trailaider.app.utils.SpacesItemDecoration;

import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by gajanand on 14/1/18.
 */

public class WalkingActivity extends BaseActivity {

    private static final String TAG = "WalkingActivty";
    private static final int MSG_UPDATE_TIME = 0;
    private static final int REQUEST_CHECK_SETTINGS = 100;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private LoginResponseData loginData;
    private TextView textViewCountDown;
    private RelativeLayout layoutCountDown;
    private AnimationSet animationSet;
    private AlphaAnimation alphaAnimation;
    private CountDownTimer timer;
    private TextView textViewBegin;
    private MediaPlayer mPlayer;

    TextView textViewTips;
    TextView textViewDuration;
    TextView textViewDistance;
    RecyclerView recyclerView;

    long time1 = 2;

    private boolean serviceBound;
    private TimerService timerService;
    private final Handler mUpdateTimeHandler = new UIUpdateHandler(this);
    private int step = 0;

    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallback;
    List<Location> locationList;
    private DecimalFormat decimalFormat;
    private TextView textViewSpeed;
    private CourseDataModel courseDataMpdel;
    private String week;
    private String day;
    private TextView textViewWeekDay;
    int totalStep;
    private CourseSectionAdapter adapter;
    private long resumeTime;
    private long pauseTime;

    /* To get the speed you will need to do this:

     int speed = location.getSpeed();

     which is in m/s, if you need to convert it to km/h use this:

     int speed=(int) ((location.getSpeed()*3600)/1000);

 if you need to convert it to mph use this:

     int speed=(int) (location.getSpeed()*2.2369);*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        courseDataMpdel = (CourseDataModel) getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA).getSerializable("data");
        Bundle bundleExtra = getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA);
        totalStep = courseDataMpdel.getCourseSectionModelList().size();
        week = bundleExtra.getString("week");
        day = bundleExtra.getString("day");
        decimalFormat = new DecimalFormat("##.##");
        mPlayer = MediaPlayer.create(this, R.raw.beep);
        loginData = TrailaiderPreferences.getInstance().getLoginData();
        initializeView();
        initializePresneter();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f,
                0.0f, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(1000);
        timer = new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {
                textViewCountDown.startAnimation(animationSet);
                textViewCountDown.setText(String.format(Locale.getDefault(), "%d", millisUntilFinished / 1000));
            }

            public void onFinish() {
                textViewBegin.setEnabled(true);
                layoutCountDown.setVisibility(View.GONE);
                mPlayer.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runButtonClick();
                    }
                }, 1000);
            }
        };
        setUpUi();
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (!CommonUtils.hasPermissions(this, ConstantLib.PERMISION_LOCATION)) {
            ActivityCompat.requestPermissions(this, ConstantLib.PERMISION_LOCATION, 104);
        } else {
            createLocationRequest();
        }
        setUpLocationCallBack();
    }

    private void setUpLocationCallBack() {
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                double speed = 0;
                for (Location location : locationResult.getLocations()) {
                    // Update UI with location data
                    // ...

                    Log.v("Location", location.getLatitude() + " , " + location.getLongitude() + ", " + location.getSpeed());
                    speed = (double) ((location.getSpeed() * 3600) / 1000);

                }
                locationList.addAll(locationResult.getLocations());
                double distanceInM = CommonUtils.computeLength(locationList);
                textViewDistance.setText(String.format("%s m", decimalFormat.format(distanceInM)));
                textViewSpeed.setText(String.format("%s Km/h", decimalFormat.format(speed)));
            }
        };

    }


    @SuppressLint("MissingPermission")
    private void startLocationUpdates() {
        mFusedLocationClient.requestLocationUpdates(mLocationRequest,
                mLocationCallback,
                null /* Looper */);
    }

    protected void createLocationRequest() {
        locationList = new ArrayList<>();
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000); // Update location every 1 minute
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);
        SettingsClient client = LocationServices.getSettingsClient(this);
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());

        task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
//                getLocation();
//                Location location = LocationTask.getLocation(AddTrekActivity.this);
//                if (location != null)
//                    Log.v("LOCATION ", location.getLatitude() + " " + location.getLongitude());
            }
        });

        task.addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    // Location settings are not satisfied, but this can be fixed
                    // by showing the user a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(WalkingActivity.this,
                                REQUEST_CHECK_SETTINGS);
                    } catch (IntentSender.SendIntentException sendEx) {
                        // Ignore the error.
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CHECK_SETTINGS) {
            if (resultCode == RESULT_OK) {

            } else {
                finish();
            }
        }
    }

    private void setUpUi() {
        textViewTips.setText(courseDataMpdel.getTips());
        textViewWeekDay.setText(String.format("%s %s", week, day));
        adapter = new CourseSectionAdapter(this, courseDataMpdel.getCourseSectionModelList());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initializePresneter() {

    }

    @Override
    public void initializeView() {
        textViewBegin = findViewById(R.id.textView_begin);
        textViewDistance = findViewById(R.id.textView_distance);
        textViewSpeed = findViewById(R.id.textView_speed);
        textViewBegin.setOnClickListener(this);
        textViewCountDown = findViewById(R.id.textView_count_down);
        layoutCountDown = findViewById(R.id.layout_count_down);
        textViewTips = findViewById(R.id.textView_tips);
        textViewDuration = findViewById(R.id.textView_duration);
        textViewWeekDay = findViewById(R.id.textView_week_day);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new SpacesItemDecoration(20));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.textView_begin:
                if (timerService.isTimerRunning()) {
                    runButtonClick();
                } else {
                    startCountDown();

                }
                break;

        }
    }

    private void startCountDown() {
        textViewBegin.setText("Stop");
        textViewBegin.setEnabled(false);
        layoutCountDown.setVisibility(View.VISIBLE);
        timer.start();
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (Log.isLoggable(TAG, Log.VERBOSE)) {
            Log.v(TAG, "Starting and binding service");
        }
        Intent i = new Intent(this, TimerService.class);
        i.putExtra("data", courseDataMpdel);
        startService(i);
        bindService(i, mConnection, 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (timerService != null && timerService.isTimerRunning()) {
            resumeTime = System.currentTimeMillis();
            textViewBegin.setText("Stop");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (serviceBound) {
            // If a timer is active, foreground the service, otherwise kill the service
            if (timerService.isTimerRunning()) {
                timerService.foreground();
                pauseTime = System.currentTimeMillis();
            } else {
                stopService(new Intent(this, TimerService.class));
            }
            // Unbind the service
            unbindService(mConnection);
            serviceBound = false;
        }
    }


    public void runButtonClick() {
        if (serviceBound && !timerService.isTimerRunning()) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "Starting timer");
            }
            timerService.startTimer();
            updateUIStartRun();
            startLocationUpdates();
        } else if (serviceBound && timerService.isTimerRunning()) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "Stopping timer");
            }
            step = 0;
            stopLocationUpdates();
            timerService.stopTimer();
            updateUIStopRun();
        }
    }

    private void stopLocationUpdates() {
        mFusedLocationClient.removeLocationUpdates(mLocationCallback);
    }

    /**
     * Updates the UI when a run starts
     */
    private void updateUIStartRun() {
        mUpdateTimeHandler.sendEmptyMessage(MSG_UPDATE_TIME);
//        timerButton.setText(R.string.timer_stop_button);
    }

    /**
     * Updates the UI when a run stops
     */
    private void updateUIStopRun() {
        mUpdateTimeHandler.removeMessages(MSG_UPDATE_TIME);
        textViewBegin.setText("Begin");
    }

    @Override
    public void onBackPressed() {
        if (timerService.isTimerRunning()) {
            showDiscardAlert();
        } else {
            if (timer != null) {
                timer.cancel();
            }
            finish();
        }
    }

    private void showDiscardAlert() {
        new AlertDialog.Builder(this).setMessage("Are you sure you want to discard this run?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (serviceBound) {
                    // If a timer is active, foreground the service, otherwise kill the service
                    stopService(new Intent(WalkingActivity.this, TimerService.class));
                    // Unbind the service
                    unbindService(mConnection);
                    serviceBound = false;
                    stopLocationUpdates();
                }
                finish();
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    /**
     * Updates the timer readout in the UI; the service must be bound
     */
    private void updateUITimer() {
        if (serviceBound) {
            String time = timerService.elapsedTime();
            long min = Integer.parseInt(time.substring(0, 2));
            long sec = Integer.parseInt(time.substring(3));
            long t = (min * 60L) + sec;
            long result = TimeUnit.SECONDS.toMillis(t);
            textViewDuration.setText(time + " Mins");
            checkResult(result);
        }
    }

    private void checkResult(long result) {
        if (step < totalStep) {
            CourseSectionModel courseSectionModel = courseDataMpdel.getCourseSectionModelList().get(step);
            if (result == courseSectionModel.getTime() * 60000) {
                timerService.stopTimer();

//                    textViewActionName1.setAlpha(0.5f);
//                    textViewActionTime1.setAlpha(0.5f);
                mPlayer.start();

                step = step + 1;
                courseSectionModel.setCompleted(true);
                courseSectionModel.setDistance(textViewDistance.getText().toString());
                courseSectionModel.setSpeed(textViewSpeed.getText().toString());
                adapter.notifyDataSetChanged();
                if (step <= totalStep - 1) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            timerService.startTimer();
                        }
                    }, 1000);
                } else {
                    timerService.stopTimer();
                    step = 0;
                    textViewBegin.setText("Begin");
                }
            }
         /*   switch (step) {
                case 1:
                    if (result == time1 * 60000) {
                        timerService.stopTimer();
//                    textViewActionName1.setAlpha(0.5f);
                        step = 2;
//                    textViewActionTime1.setAlpha(0.5f);
                        mPlayer.start();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                timerService.startTimer();
                            }
                        }, 1000);
                    }
                    break;
                case 2:
                    if (result == time2 * 60000) {
                        timerService.stopTimer();
//                    textViewActionName2.setAlpha(0.5f);
                        step = 3;
//                    textViewActionTime2.setAlpha(0.5f);
                        mPlayer.start();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                timerService.startTimer();
                            }
                        }, 1000);
                    }
                case 3:
                    if (result == time3 * 60000) {
                        timerService.stopTimer();
//                    textViewActionName3.setAlpha(0.5f);
                        step = 4;
//                    textViewActionTime3.setAlpha(0.5f);
                        mPlayer.start();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                timerService.startTimer();
                            }
                        }, 1000);
                    }
                    break;
                case 4:
                    if (result == time4 * 60000) {
                        timerService.stopTimer();
                        textViewActionName4.setAlpha(0.5f);
                        step = 5;
                        textViewActionTime4.setAlpha(0.5f);
                        mPlayer.start();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                timerService.startTimer();
                            }
                        }, 1000);
                    }
                case 5:
                    if (result == time5 * 60000) {
                        timerService.stopTimer();
                        textViewActionName5.setAlpha(0.5f);
                        step = 0;
                        textViewActionTime5.setAlpha(0.5f);
                        mPlayer.start();
                        stopLocationUpdates();
                    }
                    break;
            }*//*   switch (step) {
                case 1:
                    if (result == time1 * 60000) {
                        timerService.stopTimer();
//                    textViewActionName1.setAlpha(0.5f);
                        step = 2;
//                    textViewActionTime1.setAlpha(0.5f);
                        mPlayer.start();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                timerService.startTimer();
                            }
                        }, 1000);
                    }
                    break;
                case 2:
                    if (result == time2 * 60000) {
                        timerService.stopTimer();
//                    textViewActionName2.setAlpha(0.5f);
                        step = 3;
//                    textViewActionTime2.setAlpha(0.5f);
                        mPlayer.start();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                timerService.startTimer();
                            }
                        }, 1000);
                    }
                case 3:
                    if (result == time3 * 60000) {
                        timerService.stopTimer();
//                    textViewActionName3.setAlpha(0.5f);
                        step = 4;
//                    textViewActionTime3.setAlpha(0.5f);
                        mPlayer.start();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                timerService.startTimer();
                            }
                        }, 1000);
                    }
                    break;
                case 4:
                    if (result == time4 * 60000) {
                        timerService.stopTimer();
                        textViewActionName4.setAlpha(0.5f);
                        step = 5;
                        textViewActionTime4.setAlpha(0.5f);
                        mPlayer.start();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                timerService.startTimer();
                            }
                        }, 1000);
                    }
                case 5:
                    if (result == time5 * 60000) {
                        timerService.stopTimer();
                        textViewActionName5.setAlpha(0.5f);
                        step = 0;
                        textViewActionTime5.setAlpha(0.5f);
                        mPlayer.start();
                        stopLocationUpdates();
                    }
                    break;
            }*/
        }
    }


    /**
     * Callback for service binding, passed to bindService()
     */
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "Service bound");
            }
            TimerService.RunServiceBinder binder = (TimerService.RunServiceBinder) service;
            timerService = binder.getService();
            serviceBound = true;
            // Ensure the service is not in the foreground when bound
            timerService.background();
            // Update the UI if the service is already running the timer
            if (timerService.isTimerRunning()) {
                updateUIStartRun();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "Service disconnect");
            }
            serviceBound = false;
        }
    };

    /**
     * When the timer is running, use this handler to update
     * the UI every second to show timer progress
     */
    static class UIUpdateHandler extends Handler {

        private final static int UPDATE_RATE_MS = 1000;
        private final WeakReference<WalkingActivity> activity;

        UIUpdateHandler(WalkingActivity activity) {
            this.activity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message message) {
            if (MSG_UPDATE_TIME == message.what) {
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    Log.v(TAG, "updating time");
                }
                activity.get().updateUITimer();
                sendEmptyMessageDelayed(MSG_UPDATE_TIME, UPDATE_RATE_MS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 104) {
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    finish();
                    return;
                }
            }
            createLocationRequest();
        }
    }
}
