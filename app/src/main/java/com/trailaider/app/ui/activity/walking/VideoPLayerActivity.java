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
import com.trailaider.app.data.Session2Data;
import com.trailaider.app.utils.ConstantLib;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoPLayerActivity extends AppCompatActivity {

    private TextView textViewName, textViewRest, textViewTime;
    private JZVideoPlayerStandard jzVideoPlayerStandard;
    Session2Data exerciseModel;

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
        exerciseModel = (Session2Data) getIntent().getBundleExtra(ConstantLib.KEY_BUNDLE_EXTRA).getSerializable("data");
        textViewName.setText(exerciseModel.getTitle());
        int rest=Integer.parseInt(exerciseModel.getRestTime()!=null&&!exerciseModel.getRestTime()
                .isEmpty()?exerciseModel.getRestTime():"0");
        if (rest > 0) {
            textViewRest.setVisibility(View.VISIBLE);
            String restString = rest < 60 ?
                    rest + " seconds" :
                    rest / 60 + " minutes";
            textViewRest.setText(String.format("Rest %s", restString));
        } else
            textViewRest.setVisibility(View.GONE);
        int time = Integer.parseInt(exerciseModel.getTime()!=null&&!exerciseModel.getTime().isEmpty()?exerciseModel.getTime():"0");
        if (time > 0) {
            textViewTime.setVisibility(View.VISIBLE);
            textViewTime.setText(time < 60 ?
                    time + " seconds" :
                    time / 60 + " minutes");
        } else {
            textViewTime.setVisibility(View.GONE);
        }

        jzVideoPlayerStandard.setUp(exerciseModel.getVideo()
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
