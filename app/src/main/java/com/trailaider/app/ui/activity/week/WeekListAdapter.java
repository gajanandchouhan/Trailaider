package com.trailaider.app.ui.activity.week;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trailaider.app.R;
import com.trailaider.app.data.courses.WeekModel;
import com.trailaider.app.ui.activity.day.DayListActivty;
import com.trailaider.app.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Divya on 21-11-2017.
 */

public class WeekListAdapter extends RecyclerView.Adapter<WeekListAdapter.ItemViewHolder> {

    private final Context mContext;
    private List<WeekModel> list;

    public WeekListAdapter(Context mContext, List<WeekModel> list) {
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

        holder.textViewWeek.setText(list.get(position).getWeek());
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
            bundle.putString("week", list.get(getAdapterPosition()).getWeek());
            bundle.putSerializable("day_list", (ArrayList) list.get(getAdapterPosition()).getDaysList());
            CommonUtils.startActivity(mContext, DayListActivty.class, bundle, false);

        }
    }


}
