package com.example.vinhmai.superkids.controller;

import com.example.vinhmai.superkids.models.Topic;
import com.example.vinhmai.superkids.models.Objects;


import java.util.ArrayList;

public class TopicManager {

    private ArrayList<Topic> mTopicsList;
    private ArrayList<Objects> mObjectsList;

    private static TopicManager sInstance = null;

    private TopicManager(){
        mTopicsList = new ArrayList<>();
        mObjectsList = new ArrayList<>();
    }

    public static TopicManager getInstance(){
        if(sInstance == null){
            sInstance = new TopicManager();
        }
        return sInstance;
    }

    public void load(){
        fakeData();
    }

    public ArrayList<Topic> getTopicsList() {
        return mTopicsList;
    }

    public ArrayList<Objects> getmObjectsList(Topic topic) {
        ArrayList<Objects> list = new ArrayList<>();
        for(Objects v : mObjectsList){
            if(v.getTopicId() == topic.getId()){
                list.add(v);
            }
        }
        return list;
    }

    private void fakeData(){
        Topic t1 = new Topic(1, "T1");
        Topic t2 = new Topic(2, "T2");
        Topic t3 = new Topic(3, "T3");
        Topic t4 = new Topic(4, "T4");
        //Topic t5 = new Topic(5, "T5");

        mTopicsList.add(t1);
        mTopicsList.add(t2);
        mTopicsList.add(t3);
        mTopicsList.add(t4);
        //mTopicsList.add(t5);

        Objects v1 = new Objects(11, "W11", "S11", "L11", 21);
        Objects v2 = new Objects(12, "W12", "S12", "L12", 22);
        Objects v3 = new Objects(13, "W13", "S13", "L13", 23);
        Objects v4 = new Objects(14, "W14", "S14", "L14", 24);

        mObjectsList.add(v1);
        mObjectsList.add(v2);
        mObjectsList.add(v3);
        mObjectsList.add(v4);

        mObjectsList.add(new Objects(11, "W11", "S11", "L11", 21));
        mObjectsList.add(new Objects(12, "W12", "S12", "L12", 22));
        mObjectsList.add(new Objects(13, "W13", "S13", "L13", 23));
        mObjectsList.add(new Objects(14, "W14", "S14", "L14", 24));

    }
}
