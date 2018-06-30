package com.trailaider.app.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.CourseList;

import java.util.List;
import java.util.Locale;


/**
 * Created by Divya on 21-11-2017.
 */

public class CourseSectionAdapter extends RecyclerView.Adapter<CourseSectionAdapter.ItemViewHolder> {

    private final Context mContext;
    private final List<CourseList> list;

    public CourseSectionAdapter(Context mContext, List<CourseList> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course_section, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        CourseList courseSectionModel = list.get(position);
        if (courseSectionModel.isCompleted()) {
            holder.textViewActionTime.setAlpha(0.5f);
            holder.textViewActionText.setAlpha(0.5f);
            holder.textViewActionName.setAlpha(0.5f);

        } else {
            holder.textViewActionTime.setAlpha(1f);
            holder.textViewActionText.setAlpha(1f);
            holder.textViewActionName.setAlpha(1f);
        }
        holder.textViewActionName.setText(courseSectionModel.getTitle());
        holder.textViewActionText.setText(courseSectionModel.getDesc());
        holder.textViewActionTime.setText(String.format(Locale.getDefault(), "%s Mins", courseSectionModel.getTime()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewActionName;
        TextView textViewActionText;
        TextView textViewActionTime;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewActionName = itemView.findViewById(R.id.textView_action_name);
            textViewActionText = itemView.findViewById(R.id.textView_action_text);
            textViewActionTime = itemView.findViewById(R.id.textView_action_time);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {

            }
        }
    }


}
