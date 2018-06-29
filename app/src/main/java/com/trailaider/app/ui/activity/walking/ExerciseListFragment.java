package com.trailaider.app.ui.activity.walking;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.courses.ExerciseModel;
import com.trailaider.app.data.model.login.LoginResponseData;
import com.trailaider.app.ui.fragment.BaseFragment;
import com.trailaider.app.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by gajanand on 24/2/18.
 */

public class ExerciseListFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private LoginResponseData loginData;
    private ExerciseListAdapter adapter;
    private List<ExerciseModel> list;
    private int current = 0;
    private ExerciseModel exerciseModel;
    private CountDownTimer cdt;
    private ImageView imageViewPlay;
    private TextView textViewCountDown;
    private RelativeLayout layoutCountDown;
    private MediaPlayer mPlayer;
    private CountDownTimer timer;
    private AnimationSet animationSet;
    private AlphaAnimation alphaAnimation;

    private long miliForTImer;
    private boolean excerSizeRunning;

    private boolean firstRun = true;
    private boolean excerSizePaused;
    private boolean isPaused;
    private TextView textViewTime;

    public static ExerciseListFragment newInstance() {
        Bundle args = new Bundle();
        ExerciseListFragment fragment = new ExerciseListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exercise_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializePresenter();
        initializeView(view);
        mPlayer = MediaPlayer.create(getActivity(), R.raw.beep);
        recyclerView = view.findViewById(R.id.recycler_view);
        imageViewPlay = view.findViewById(R.id.button_play);
        imageViewPlay.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new ExerciseListAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);
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
                imageViewPlay.setEnabled(true);
                layoutCountDown.setVisibility(View.GONE);
                mPlayer.start();
                startExercise();
            }
        };
    }

    @Override
    public void onPause() {
        super.onPause();
        if (timer != null) {
            timer.cancel();
            layoutCountDown.setVisibility(View.GONE);
        }
        if (!firstRun && !isPaused)
            imageViewPlay.performClick();
       /* if (excerSizeRunning && cdt != null) {
            cdt.cancel();
            excerSizePaused = true;
        }*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
        if (cdt != null) {
            cdt.cancel();
        }
    }

    private void startCount() {
        layoutCountDown.setVisibility(View.VISIBLE);
        imageViewPlay.setEnabled(false);
        timer.start();
    }


    private void startExercise() {
        excerSizeRunning = true;
        /** CountDownTimer starts with 1 minutes and every onTick is 1 second */
        cdt = new CountDownTimer(miliForTImer, 100) {

            public void onTick(long millisUntilFinished) {
                miliForTImer = millisUntilFinished;
                long total = exerciseModel.getSeconds()*1000;
                long remains = total - millisUntilFinished;
                int seconds = (int) (remains / 1000) % 60;
                int minutes = (int) ((remains / (1000 * 60)) % 60);
                String format = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                textViewTime.setText(format);
                //                int progress = (int) ((exerciseModel.getSeconds() * 1000- millisUntilFinished) / 1000);

                Log.v("TIMER", "" + exerciseModel.getProgress());
                int p = exerciseModel.getProgress() + 1;
                exerciseModel.setProgress(p);
                adapter.notifyItemChanged(current);
            }

            public void onFinish() {
                // DO something when 1 minute is up
                current = current + 1;
                if (current <= list.size() - 1) {
                    mPlayer.start();
                    exerciseModel = list.get(current);
                    miliForTImer = exerciseModel.getSeconds() * 1000;
                    startCount();
                }

            }
        }.start();
    }



    @Override
    public void onResume() {
        super.onResume();
        if (!firstRun && !isPaused)
            imageViewPlay.performClick();
    }


    @Override
    protected void initializeView(View view) {
        textViewCountDown = view.findViewById(R.id.textView_count_down);
        layoutCountDown = view.findViewById(R.id.layout_count_down);
        textViewTime = view.findViewById(R.id.textView_time);
    }

    @Override
    protected void initializePresenter() {
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.button_play:
                if (list != null && list.size() > 0) {
                    if (excerSizeRunning) {
                        excerSizeRunning = false;
                        isPaused = true;
                        cdt.cancel();
                        imageViewPlay.setImageResource(R.drawable.jz_play_normal);
                    } else {
                        isPaused = false;
                        if (firstRun) {
                            exerciseModel = list.get(current);
                            miliForTImer = exerciseModel.getSeconds() * 1000;
                            firstRun = false;
                            startCount();
                            imageViewPlay.setImageResource(R.drawable.jz_pause_normal);
                            return;
                        }
                        startExercise();
                        imageViewPlay.setImageResource(R.drawable.jz_pause_normal);


                    }

                }
                break;
        }
    }

    public void setList(List<ExerciseModel> list) {
        this.list.clear();
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
    }


}
