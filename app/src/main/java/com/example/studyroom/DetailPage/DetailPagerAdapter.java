package com.example.studyroom.DetailPage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.studyroom.R;

import java.util.ArrayList;

public class DetailPagerAdapter extends PagerAdapter {

    Context context;
    ArrayList<String> roomImages;
    RequestManager requestManager;
    public DetailPagerAdapter(Context context, ArrayList<String> roomImages) {
        this.context = context;
        this.roomImages = roomImages;
        requestManager = Glide.with(context);
    }

    @Override
    public int getCount() {
        return roomImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.detail_card_item, container, false);
        container.addView(view);
        ImageView imageView = view.findViewById(R.id.image_view);
        requestManager.load(roomImages.get(position)).into(imageView);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
