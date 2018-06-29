package com.trailaider.app.ui.activity.walking;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.courses.ExerciseModel;
import com.trailaider.app.utils.ConstantLib;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoPLayerActivity extends AppCompatActivity {

    private TextView textViewName, textViewRest, textViewTime;
    private JZVideoPlayerStandard jzVideoPlayerStandard;
    ExerciseModel exerciseModel;
    String VIDEO_BASE_URL = "http://trailaider.orangeboxtechnologies.com/media/course_videos/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        jzVideoPlayerStandard = findViewById(R.id.videoplayer);
        textViewName = findViewById(R.id.textView_title);
        textViewRest = findViewById(R.id.textView_rest);
        textViewTime = findViewById(R.id.textView_time);
        exerciseModel = (ExerciseModel) getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA).getSerializable("data");
        textViewName.setText(exerciseModel.getName());
        if (exerciseModel.getRest() > 0) {
            textViewRest.setVisibility(View.VISIBLE);
            String rest = exerciseModel.getRest() < 60 ?
                    exerciseModel.getRest() + " seconds" :
                    exerciseModel.getRest() / 60 + " minutes";
            textViewRest.setText(String.format("Rest %s", rest));
        } else
            textViewRest.setVisibility(View.GONE);
        if (exerciseModel.getSeconds() > 0){
            textViewTime.setVisibility(View.VISIBLE);
            textViewTime.setText(exerciseModel.getSeconds() < 60 ?
                    exerciseModel.getSeconds() + " seconds" :
                    exerciseModel.getSeconds() / 60 + " minutes");
        }else{
            textViewTime.setVisibility(View.GONE);
        }

        jzVideoPlayerStandard.setUp(VIDEO_BASE_URL + exerciseModel.getName() + ".mp4"
                , JZVideoPlayerStandard.SCREEN_WINDOW_LIST);
        jzVideoPlayerStandard.startButton.performClick();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
