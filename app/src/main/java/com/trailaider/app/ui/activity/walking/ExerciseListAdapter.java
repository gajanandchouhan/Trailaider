package com.trailaider.app.ui.activity.walking;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.courses.ExerciseModel;
import com.trailaider.app.utils.CommonUtils;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;


/**
 * Created by Divya on 21-11-2017.
 */

public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ItemViewHolder> {

    private final Context mContext;
    private final List<ExerciseModel> list;

    public ExerciseListAdapter(Context mContext, List list) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_exercise_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ExerciseModel exerciseModel = list.get(position);
        holder.textViewName.setText(exerciseModel.getName());
        if (exerciseModel.getRest() > 0) {
            holder.textViewRest.setVisibility(View.VISIBLE);
            String rest = exerciseModel.getRest() < 60 ?
                    exerciseModel.getRest() + " seconds" :
                    exerciseModel.getRest() / 60 + " minutes";
            holder.textViewRest.setText(String.format("Rest %s", rest));
        } else {
            holder.textViewRest.setVisibility(View.GONE);
        }
        if (exerciseModel.getSeconds() > 0) {
            holder.textViewTime.setVisibility(View.VISIBLE);
            holder.textViewTime.setText(exerciseModel.getSeconds() < 60 ?
                    exerciseModel.getSeconds() + " seconds" :
                    exerciseModel.getSeconds() / 60 + " minutes");
            holder.seekBar.setMax((int) exerciseModel.getSeconds() * 10);
        } else {
            holder.textViewTime.setVisibility(View.GONE);
        }
        holder.seekBar.setProgress(exerciseModel.getProgress());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        JZVideoPlayerStandard jzVideoPlayerStandard;
        TextView textViewName;
        TextView textViewRest;
        TextView textViewTime;
        AppCompatSeekBar seekBar;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            jzVideoPlayerStandard = itemView.findViewById(R.id.videoplayer);
            textViewName = itemView.findViewById(R.id.textView_title);
            textViewRest = itemView.findViewById(R.id.textView_rest);
            textViewTime = itemView.findViewById(R.id.textView_time);
            seekBar = itemView.findViewById(R.id.seek_bar);
            seekBar.setEnabled(false);
        }

        @Override
        public void onClick(View view) {
//              playVideo("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");

//            FriendModel friendModel = list.get(getAdapterPosition());
//            Bundle bundle = new Bundle();
//            bundle.putString("id", friendModel.getId());
//            CommonUtils.startActivity(mContext, ReviewUserProfileActivity.class, bundle, false);
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", list.get(getAdapterPosition()));
            CommonUtils.startActivity(mContext, VideoPLayerActivity.class, bundle, false);
        }
    }


}
