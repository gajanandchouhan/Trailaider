package com.trailaider.app.ui.activity.week;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.CourseApiContent;
import com.trailaider.app.data.courses.WeekModel;
import com.trailaider.app.ui.activity.day.DayListActivty;
import com.trailaider.app.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by Divya on 21-11-2017.
 */

public class WeekListAdapter extends RecyclerView.Adapter<WeekListAdapter.ItemViewHolder> {

    private final Context mContext;
    private List<CourseApiContent> list;

    public WeekListAdapter(Context mContext, List<CourseApiContent> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_week_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        holder.textViewWeek.setText(String.format(Locale.getDefault(),"Week %d", position + 1));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewWeek;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewWeek = itemView.findViewById(R.id.textView_week);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString("week", String.format(Locale.getDefault(),"Week %d", getAdapterPosition() + 1));
            bundle.putSerializable("day_list", (ArrayList) list.get(getAdapterPosition()).getDays());
            CommonUtils.startActivity(mContext, DayListActivty.class, bundle, false);

        }
    }


}
