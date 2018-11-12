package com.example.vinhmai.superkids.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.vinhmai.superkids.models.Objects;
import com.example.vinhmai.superkids.R;

import java.util.ArrayList;

public abstract class NumberPageAdapter extends PagerAdapter {
    private Context context;
    private int layoutId;
    private ArrayList<Objects> list;

    public NumberPageAdapter(Context context, int layoutId, ArrayList<Objects> list){
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, java.lang.Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(layoutId, container, Boolean.parseBoolean(null));

        ImageView  imgNumber = layout.findViewById(R.id.imgView);
        Button btnSound = layout.findViewById(R.id.btnSound);

        Objects objects = new Objects();
        imgNumber.setImageResource(Integer.parseInt(objects.getImage()));
        btnSound.setBottom(Integer.parseInt(objects.getSound()));

        container.addView(layout);
        return layout;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
