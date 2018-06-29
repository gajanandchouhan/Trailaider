package com.trailaider.app.ui.activity.day;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.courses.CourseDataModel;
import com.trailaider.app.ui.activity.walking.ExerciseActivity;
import com.trailaider.app.ui.activity.walking.PreWalkingActivity;
import com.trailaider.app.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by Divya on 21-11-2017.
 */

public class DayListAdapter extends RecyclerView.Adapter<DayListAdapter.ItemViewHolder> {

    private final Context mContext;
    private final String noOfWeek;
    private List<CourseDataModel> list;
    int visiblePos = 0;

    public DayListAdapter(Context mContext, List<CourseDataModel> list, String noOfWeeks) {
        this.mContext = mContext;
        this.list = list;
        this.noOfWeek = noOfWeeks;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_day_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (list.get(position).getExercise()!=null&&list.get(position).getExercise().size()>0) {
            holder.textViewSession2.setVisibility(View.VISIBLE);
            holder.textViewSession1.setText("Session 1");
            holder.textViewSession2.setText("Session 2");
        } else {
            holder.textViewSession2.setVisibility(View.GONE);
            holder.textViewSession1.setText("Session 1");
        }
        if (position == visiblePos)
            holder.layoutTask.setVisibility(View.VISIBLE);
        else
            holder.layoutTask.setVisibility(View.GONE);
        holder.textViewDay.setText(String.format(Locale.getDefault(), "Day %d", position + 1));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewDay;
        LinearLayout layoutTask;
        TextView textViewSession1;
        TextView textViewSession2;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewDay = itemView.findViewById(R.id.textView_day);
            layoutTask = itemView.findViewById(R.id.layout_task);
            textViewSession1 = itemView.findViewById(R.id.textView_session_1);
            textViewSession2 = itemView.findViewById(R.id.textView_session_2);
            textViewDay.setOnClickListener(this);
            textViewSession1.setOnClickListener(this);
            textViewSession2.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.textView_day:
                    visiblePos = getAdapterPosition();
                    notifyDataSetChanged();
                    break;
                case R.id.textView_session_1:
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("data", list.get(getAdapterPosition()));
                    bundle.putString("week", noOfWeek);
                    bundle.putString("day", "Day " + (getAdapterPosition() + 1));
                    CommonUtils.startActivity(mContext, PreWalkingActivity.class, bundle, false);
                    break;
                case R.id.textView_session_2:
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("data", (ArrayList) list.get(getAdapterPosition()).getExercise());
                    CommonUtils.startActivity(mContext, ExerciseActivity.class, bundle2, false);
                    break;
            }

        }
    }

    void setUpUi(int step) {


    }

}
