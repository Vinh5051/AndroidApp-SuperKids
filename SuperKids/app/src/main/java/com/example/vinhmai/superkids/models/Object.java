package com.example.vinhmai.superkids.models;

import java.io.Serializable;

public class Object implements Serializable {
    private int id;
    private String word;
    private String sound;
    private String image;
    private int topicId;


    public Object(int id, String word, String sound, String image, int topicId) {
        this.id = id;
        this.word = word;
        this.sound = sound;
        this.image = image;
        this.topicId = topicId;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String pronunciation) {
        this.sound = sound;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "Object{" +
                "word='" + word + '\'' +
                ", voice='" + sound + '\'' +
                ", image='" + image + '\'' +
                ", topicId=" + topicId +
                '}';
    }
}


