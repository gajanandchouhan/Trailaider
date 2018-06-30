package com.trailaider.app.ui.fragment.courses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trailaider.app.R;


/**
 * Created by Divya on 21-11-2017.
 */

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ItemViewHolder> {

    private final Context mContext;

    public CourseListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_course_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

       if (position==0){
           holder.textViewCourse.setText("CURRENT COURSE PROGRESS");
       }
       else{
           holder.textViewCourse.setText("PREVIOUS COURSE PROGRESS");
       }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCourse;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewCourse= itemView.findViewById(R.id.course_textView);
        }
    }


}
