package com.trailaider.app.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.trailaider.app.GlideApp;
import com.trailaider.app.R;
import com.trailaider.app.data.model.review.ReviewImageModel;
import com.trailaider.app.data.model.trek.TrekImageModel;

import java.util.List;

/**
 * Created by gajanand on 11/3/18.
 */

public class ImagePagerAdapter extends PagerAdapter {

    private final List list;

    public ImagePagerAdapter(List list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(collection.getContext());
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.item_image, collection, false);
        ImageView viewById = layout.findViewById(R.id.imageView);
        Object o = list.get(position);
        if (o instanceof ReviewImageModel) {
            ReviewImageModel model = (ReviewImageModel) o;
            GlideApp.with(viewById.getContext()).
                    load(model.getReview_image()).placeholder(R.drawable.placeholder).
                    into((viewById));
        }else if (o instanceof TrekImageModel){
            TrekImageModel model = (TrekImageModel) o;
            GlideApp.with(viewById.getContext()).
                    load(model.getTrek_image()).placeholder(R.drawable.placeholder).
                    into((viewById));
        }
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((RelativeLayout) view);
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
