package com.trailaider.app.ui.fragment.trek;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.trek.TrekImageModel;
import com.trailaider.app.data.model.trek.TrekResponseData;
import com.trailaider.app.ui.activity.BaseActivity;
import com.trailaider.app.ui.dialog.SelectionListDialog;
import com.trailaider.app.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Divya on 21-11-2017.
 */

public class TrekListAdapter extends RecyclerView.Adapter<TrekListAdapter.ItemViewHolder> {

    private final Context mContext;
    private final List<TrekResponseData> list;
    private List<String> optionList;

    public TrekListAdapter(Context mContext, List<TrekResponseData> list) {
        this.mContext = mContext;
        this.list = list;
        optionList = new ArrayList<>();
        optionList.add("Share");
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trek_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        TrekResponseData trekResponseData = list.get(position);
        holder.textViewDays.setText(String.format("%s days", trekResponseData.getTrek_duration()));
        holder.textViewHeight.setText(trekResponseData.getTrek_height());
        holder.textViewTrekName.setText(trekResponseData.getTrek_name());
        holder.textViewWith.setText(trekResponseData.getTrek_type());
        switch (trekResponseData.getTrek_status()) {
            case "0":
                holder.textStatus.setText(R.string.pending);
                holder.textStatus.setBackgroundResource(R.color.colorRed);
                break;
            case "1":
                holder.textStatus.setText(R.string.aproved);
                holder.textStatus.setBackgroundResource(R.color.colorGreen);
                break;
            default:
                holder.textStatus.setText(R.string.pending);
                holder.textStatus.setBackgroundResource(R.color.colorRed);
                break;
        }
        try {
            if (trekResponseData.getTrek_images() != null && trekResponseData.getTrek_images().size() > 0) {
                GlideApp.with(holder.imageViewTrek).load(trekResponseData.getTrek_images().get(0).getTrek_image())
                        .placeholder(R.drawable.placeholder).into(holder.imageViewTrek);
            }
        } catch (Exception e) {

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewTrek;
        TextView textViewTrekName;
        TextView textViewWith;
        TextView textViewDays;
        TextView textViewHeight;
        TextView textStatus;


        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewTrekName = itemView.findViewById(R.id.textView_title);
            textViewWith = itemView.findViewById(R.id.textView_with);
            textViewDays = itemView.findViewById(R.id.textView_days);
            textViewHeight = itemView.findViewById(R.id.textView_ft);
            textStatus = itemView.findViewById(R.id.textView_status);
            imageViewTrek = itemView.findViewById(R.id.image_view_trek);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    showShareDialog(getAdapterPosition());
                    return true;
                }
            });
        }
    }

    private void showShareDialog(final int adapterPosition) {
        new SelectionListDialog(mContext, optionList, new SelectionListDialog.SelectedListner<String>() {
            @Override
            public void onSelected(int position, String object) {
                BaseActivity activity = (BaseActivity) mContext;
                TrekResponseData trekResponseData=list.get(adapterPosition);
                List<TrekImageModel> trek_images = list.get(adapterPosition).getTrek_images();
                String image = trek_images != null && trek_images.size() > 0 ? trek_images.get(0).getTrek_image() : null;
                StringBuilder builder=new StringBuilder();
                builder.append("Trek Name :"+trekResponseData.getTrek_name()+"\n");
                builder.append("Trek Duration :"+String.format("%s days", trekResponseData.getTrek_duration())+"\n");
                builder.append("Trek Height :"+trekResponseData.getTrek_height()+"\n");
                builder.append("Trek Type :"+trekResponseData.getTrek_type()+"\n");
                String text= builder.toString();
                activity.shareContent(text,image);
            }
        }).show();
    }


}
