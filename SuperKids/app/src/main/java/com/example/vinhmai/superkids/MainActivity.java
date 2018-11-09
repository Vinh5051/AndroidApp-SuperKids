package com.example.vinhmai.superkids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStart,btnMan,btnGird,btnTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFormWidgets();
        addEventWidgets();
        animationWidgets();

    }


    public void getFormWidgets() {
        btnStart = findViewById(R.id.start);
        btnMan = findViewById(R.id.btnMan);
        btnGird = findViewById(R.id.btnGird);
        btnTitle = findViewById(R.id.btnTitle);
    }

    private void addEventWidgets() {
        btnStart.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TopicActivity.class);
                startActivity(intent);
            }
        });
    }

    private void animationWidgets() {
        Animation animManFade =  AnimationUtils.loadAnimation(getApplicationContext(), R.anim.superman_translate);
        //animManFade.setStartOffset(2000);
        btnMan.startAnimation(animManFade);
        Animation animGirdFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.supergird_translate);
        btnGird.startAnimation(animGirdFade);
        Animation animTitleFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.title_animation);
        btnTitle.startAnimation(animTitleFade);
        Animation animStartFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.start_animation);
        btnStart.startAnimation(animStartFade);
    }
}
