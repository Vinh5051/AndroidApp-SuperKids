package com.example.vinhmai.superkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TopicActivity extends AppCompatActivity {

    private Button btnChar,btnNumber,btnColor,btnShaep,btnAP,btnPractive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        getFormWidgets();
        addEventWidgets();

    }


    private void getFormWidgets() {
        btnChar = findViewById(R.id.btnChar);
        btnNumber = findViewById(R.id.btnNumber);
        btnColor = findViewById(R.id.btnColor);
        btnShaep = findViewById(R.id.btnShaep);
        btnAP = findViewById(R.id.btnAP);
        btnPractive = findViewById(R.id.btnPractive);

    }

    private void addEventWidgets() {
        btnChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopicActivity.this, CharacterDetailActivity.class);
                startActivity(intent);
            }
        });

        btnNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopicActivity.this, NumberDetailActivity.class);
                startActivity(intent);
            }
        });

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopicActivity.this, ColorDetailActivity.class);
                startActivity(intent);
            }
        });

        btnShaep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopicActivity.this, ShaepDetailActivity.class);
                startActivity(intent);
            }
        });

        btnAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopicActivity.this, AnimalAndPlantDetailActivity.class);
                startActivity(intent);
            }
        });

        btnPractive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopicActivity.this, PractiveDetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
