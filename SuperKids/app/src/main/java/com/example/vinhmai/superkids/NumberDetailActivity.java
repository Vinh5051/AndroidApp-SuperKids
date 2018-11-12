package com.example.vinhmai.superkids;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.vinhmai.superkids.adapter.NumberPageAdapter;
import com.example.vinhmai.superkids.controller.TopicManager;
import com.example.vinhmai.superkids.models.Objects;
import com.example.vinhmai.superkids.models.Topic;

import java.util.ArrayList;

public class NumberDetailActivity extends AppCompatActivity {

    private ViewPager vpNumber;
    private NumberPageAdapter adapter;
    private ArrayList<Objects> list;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_details_activity);

        innit();
        getWidgets();
        setWidgets();
        addListener();

    }

    private void innit() {
        ArrayList<Topic> topics = TopicManager.getInstance().getTopicsList();
        list = TopicManager.getInstance().getmObjectsList(topics.get(0));

    }

    private void getWidgets() {
        vpNumber = findViewById(R.id.vpNumber);
    }

    private void setWidgets() {
        setViewPager();
    }

    private void addListener() {
        vpNumber.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }



    private void setViewPager(){
        adapter = new NumberPageAdapter(this,
                R.layout.number_details_activity, list) {

        };
        vpNumber.setAdapter(adapter);
    }

    public void showHideChecking(View view) {
        setViewPager();
    }


}
