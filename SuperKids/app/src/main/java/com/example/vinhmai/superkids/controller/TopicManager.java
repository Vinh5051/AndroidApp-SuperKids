package com.example.vinhmai.superkids.controller;

import com.example.vinhmai.superkids.models.Topic;
import com.example.vinhmai.superkids.models.Object;


import java.util.ArrayList;

public class TopicManager {

    private ArrayList<Topic> mTopicsList;
    private ArrayList<Object> mObjectsList;

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

    public ArrayList<Object> getmObjectsList(Topic topic) {
        ArrayList<Object> list = new ArrayList<>();
        for(Object v : mObjectsList){
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

        mTopicsList.add(t1);
        mTopicsList.add(t2);
        mTopicsList.add(t3);
        mTopicsList.add(t4);

        Object v1 = new Object("W11", "P11", "M11", 1);
        Object v2 = new Object("W12", "P12", "M12", 1);
        Object v3 = new Object("W13", "P13", "M13", 1);
        Object v4 = new Object("W14", "P14", "M14", 1);

        mObjectsList.add(v1);
        mObjectsList.add(v2);
        mObjectsList.add(v3);
        mObjectsList.add(v4);

        mObjectsList.add(new Object("W21", "P21", "M21", 2));
        mObjectsList.add(new Object("W22", "P22", "M22", 2));
        mObjectsList.add(new Object("W23", "P23", "M23", 2));
        mObjectsList.add(new Object("W24", "P24", "M24", 2));

    }
}
